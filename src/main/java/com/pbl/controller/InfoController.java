package com.pbl.controller;

import com.pbl.entity.RestBean;
import com.pbl.entity.vo.response.AccountVO;
import com.pbl.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * */
@RestController
@Validated
@Tag(name="用户接口校验",description = "这个是用作用户登录的")
@RequestMapping("/api/user")
public class InfoController {

    @Resource
    AccountService service;
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "请求用户数据测试接口")   //接口功能描述
    @ResponseBody
    @GetMapping("/index")
    public RestBean<AccountVO> getIndexData(String studentID) {
        // 调用服务类的方法获取数据
        AccountVO accountVo = service.findAccountByStudentID(studentID);

        // 返回一个成功的 RestBean 对象
        return RestBean.success(accountVo);
    }

}
