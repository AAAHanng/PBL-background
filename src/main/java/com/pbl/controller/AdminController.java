package com.pbl.controller;

import com.pbl.entity.RestBean;
import com.pbl.entity.dto.Admin;
import com.pbl.entity.dto.Teacher;
import com.pbl.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@Validated
@Tag(name="管理员接口",description = "这些接口是服务管理员的")
public class AdminController {

    @Resource
    AdminService adminService;

    /**
     * 用户登录主页之后根据工号进入系统
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "用户登录主页之后根据工号进入系统 查看到qq等信息" )   //接口功能描述
    @ResponseBody
    @GetMapping("/getContact")
    public RestBean<Admin> getContact(@RequestParam String studentId) {
        // 调用服务类的方法获取数据
        Admin data = adminService.getContactByTeacherID(studentId);
        System.out.println(data);
        if (data == null) return RestBean.failure(400,"没有该用户");
        // 返回一个成功的 RestBean 对象
        return RestBean.success(data);
    }
}
