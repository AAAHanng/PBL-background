package com.pbl.controller;

import com.pbl.entity.RestBean;
import com.pbl.entity.dto.Admin;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.Teacher;
import com.pbl.service.AdminService;
import com.pbl.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@Validated
@Tag(name="管理员接口",description = "这些接口是服务管理员的")
public class AdminController {

    @Resource
    AdminService adminService;

    @Resource
    CourseService courseService;

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

    /**
     * 管理员 获取课程
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员看到所有的课程" )   //接口功能描述
    @ResponseBody
    @GetMapping("/getCourse")
    public RestBean<List<Map<String,Object>>> getCourse() {
        // 调用服务类的方法获取数据
        List<Map<String,Object>> data = adminService.getCourse();
        return RestBean.success(data);
    }

    /**
     * 管理员 增加课程
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员增加课程" )   //接口功能描述
    @ResponseBody
    @GetMapping("/addCourse")
    public RestBean<String> addCourse(@RequestBody Course course) {
        // 调用服务类的方法获取数据
        String data = courseService.addCourse(course);
        return RestBean.success(data);
    }

    /**
     * 管理员 删除课程
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员删除课程" )   //接口功能描述
    @ResponseBody
    @GetMapping("/DeleteCourse")
    public RestBean<String> DeleteCourse(String courseId) {
        // 调用服务类的方法获取数据
        String  data = courseService.deleteCourse(courseId);
        return RestBean.success(data);
    }

    /**
     * 管理员 更改课程
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员更改课程" )   //接口功能描述
    @ResponseBody
    @GetMapping("/updateCourse")
    public RestBean<String> updateCourse(@RequestBody Course course) {
        // 调用服务类的方法获取数据
        String data = courseService.updateCourse(course);
        return RestBean.success(data);
    }
}
