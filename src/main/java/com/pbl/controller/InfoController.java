package com.pbl.controller;

import com.pbl.entity.RestBean;
import com.pbl.entity.vo.response.AccountVO;
import com.pbl.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * */
@RestController
@Validated
@Tag(name="学生端接口",description = "这个是用户信息端")
@RequestMapping("/api/user")
public class InfoController {

    @Resource
    AccountService service;


    /**
     * 用户登录主页之后根据学号进入系统
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "请求用户数据接口")   //接口功能描述
    @ResponseBody
    @GetMapping("/contact")
    public RestBean<AccountVO> getIndexData(@RequestParam String studentID) {
        // 调用服务类的方法获取数据
        AccountVO accountVo = service.findAccountByStudentID(studentID);

        // 返回一个成功的 RestBean 对象
        return RestBean.success(accountVo);
    }


    /**
     * 用户根据学号 来修改信息
     * @param //request 请求学号  phone email wechat qq
     * @return RestBean 对象
     */
    @Operation(summary = "更新用户联系信息", description = "更新用户的手机、邮件、微信和 QQ 号")
    @PutMapping("/update-contact-info")
    public RestBean<Void> updateContactInfo(
            @RequestParam(name = "StudentID") String StudentID,
            @RequestParam(name = "phone" ,required = false) @Pattern(regexp = "^1[3456789]\\d{9}$") String phone,
            @RequestParam(name = "email", required = false) @Email String email,
            @RequestParam(name = "wechat", required = false) String wechat,
            @RequestParam(name = "qq", required = false) @Pattern(regexp = "^[0-9]{5,12}$") String qq,
            @RequestParam(name = "bio", required = false) String bio
    ) {
        String message = service.updateContactInfo(StudentID, phone, email, wechat, qq,bio);
        return (message == null) ? RestBean.failure(401, "更改信息失败") : RestBean.success();
    }
}
