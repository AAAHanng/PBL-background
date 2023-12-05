package com.pbl.controller;


import com.pbl.entity.RestBean;
import com.pbl.entity.dto.Student;
import com.pbl.entity.dto.Teacher;
import com.pbl.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/teacher")
@Tag(name="老师端接口",description = "这些接口是服务老师")
public class TeacherController {

    @Resource
    TeacherService teacherService;

    /**
     * 用户根据工号来修改信息
     * @param //request 请求工号 phone email wechat qq
     * @return RestBean 对象
     */
    @Operation(summary = "更新用户联系信息 根据工号", description = "更新用户的手机、邮件、微信和 QQ 号 ")
    @PutMapping("/updateInfo")
    public RestBean<Void> updateContactInfo(
            @RequestParam(name = "teacherId") String teacherId,
            @RequestParam(name = "phone" ,required = false) @Pattern(regexp = "^1[3456789]\\d{9}$") String phone,
            @RequestParam(name = "email", required = false) @Email String email,
            @RequestParam(name = "wechat", required = false) String wechat,
            @RequestParam(name = "qq", required = false) @Pattern(regexp = "^[0-9]{5,12}$") String qq,
            @RequestParam(name = "bio", required = false) String bio
    ) {
        String message = teacherService.updateInfo(teacherId, phone, email, wechat, qq,bio);
        return (message == null) ? RestBean.failure(401, "更改信息失败") : RestBean.success();
    }

    /**
     * 用户登录主页之后根据工号进入系统
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "用户登录主页之后根据工号进入系统 查看到qq等信息" )   //接口功能描述
    @ResponseBody
    @GetMapping("/getContact")
    public RestBean<Teacher> getContact(@RequestParam String teacherId) {
        // 调用服务类的方法获取数据
        Teacher data = teacherService.getContactByStudentID(teacherId);
        if (data == null) return RestBean.failure(400,"没有该用户");
        // 返回一个成功的 RestBean 对象
        return RestBean.success(data);
    }
}
