package com.pbl.configuration;

import com.pbl.entity.RestBean;
import com.pbl.entity.dto.Student;
import com.pbl.entity.vo.response.AuthorizeVO;
import com.pbl.filter.JwtAuthenticationFilter;
import com.pbl.service.StudentService;
import com.pbl.utils.JwtUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.PrintWriter;

/*
    Spring Security配置类
*/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

        /*
        *   这是User的接口
        *  */
        @Resource
        private StudentService service;

        @Resource
        JwtUtils utils;

        @Resource
        JwtAuthenticationFilter jwtAuthenticationFilter;
        /*
        * 这是注册了一个加密的编码
        */
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }


        /**
         * 针对于 SpringSecurity 6 的新版配置方法
         * @param http 配置器
         * @return 自动构建的内置过滤器链
         * @throws Exception 可能的异常
         */
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .authorizeHttpRequests(conf -> conf
                            .requestMatchers("/api/auth/**" ,"/error").permitAll()
                            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                            .requestMatchers("/api/file/**").permitAll()
                            .anyRequest().authenticated()
                    )
                    .formLogin(conf -> conf
                            .loginProcessingUrl("/api/auth/login")
                            .failureHandler(this::handleProcess)
                            .successHandler(this::handleProcess)
                            .permitAll()
                    )
                    .logout(conf -> conf
                            .logoutUrl("/api/auth/logout")
                            .logoutSuccessHandler(this::onLogoutSuccess)
                    )
                    .exceptionHandling(conf -> conf
                            .accessDeniedHandler(this::handleProcess)
                            .authenticationEntryPoint(this::handleProcess)
                    )
                    .csrf(AbstractHttpConfigurer::disable)
                    .sessionManagement(conf -> conf
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
        }

        /**
         * 将多种类型的Handler整合到同一个方法中，包含：
         * - 登录成功
         * - 登录失败
         * - 未登录拦截/无权限拦截
         * @param request 请求
         * @param response 响应
         * @param exceptionOrAuthentication 异常或是验证实体
         * @throws IOException 可能的异常
         */
        private void handleProcess(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object exceptionOrAuthentication) throws IOException {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            if(exceptionOrAuthentication instanceof AccessDeniedException exception) {
                writer.write(RestBean
                        .forbidden(exception.getMessage()).asJsonString());
                // 如果 exceptionOrAuthentication 是 AccessDeniedException 类型的异常       创建一个表示访问被拒绝的 JSON 响应。
            } else if(exceptionOrAuthentication instanceof Exception exception) {
                writer.write(RestBean
                        .unauthorized(exception.getMessage()).asJsonString());
                //如果 exceptionOrAuthentication 是 Exception 类型的异常（泛指其他异常），则返回一个包含未授权信息的JSON响应
            } else if(exceptionOrAuthentication instanceof Authentication authentication){
                User user = (User) authentication.getPrincipal();
                Student student = service.findAccountByNameOrEmail(user.getUsername());
                String jwt = utils.createJwt(user, student.getUserName(), student.getUserID());
                if(jwt == null) {
                    writer.write(RestBean.forbidden("登录验证频繁，请稍后再试").asJsonString());
                } else {
                    AuthorizeVO vo = new AuthorizeVO();
                    vo.setExpire(utils.expireTime());
                    vo.setToken(jwt);
                    vo.setUsername(student.getUserName());
                    writer.write(RestBean.success(vo).asJsonString());
                }
            }
        }

    /**
     * 退出登录处理，将对应的Jwt令牌列入黑名单不再使用
     * @param request 请求
     * @param response 响应
     * @param authentication 验证实体
     * @throws IOException 可能的异常
     */
    private void onLogoutSuccess(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String authorization = request.getHeader("Authorization");
        if(utils.invalidateJwt(authorization)) {
            writer.write(RestBean.success("退出登录成功").asJsonString());
            return;
        }
        writer.write(RestBean.failure(400, "退出登录失败").asJsonString());
    }
}
