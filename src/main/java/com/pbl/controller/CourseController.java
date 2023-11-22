package com.pbl.controller;


import com.pbl.entity.RestBean;
import com.pbl.entity.dto.Course;
import com.pbl.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/course")
@Tag(name = "学生端口", description = "包括课程信息 选课信息等")
public class CourseController {

    @Resource
    CourseService service;

    /**
     * 学生用户登录主页之后课程列表
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "全部课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/contact")
    public RestBean<List<Course>> contact(){
        return RestBean.success(service.FindAllCourse());
    }

    /**
     * 学生用户登录主页之后选择课程列表
     * @param // StudentID
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "已经选择的课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/alContact")
    public RestBean<List<Course>> FindALCourse(String studentID){
        return RestBean.success(service.FindALCourse(studentID));
    }

    /**
     * 学生用户登录主页之后课程列表
     *
     * @param // StudentID
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "发送课程请求")   //接口功能描述
    @ResponseBody
    @GetMapping("/CourseRequest")
    public RestBean<String> submitCourseRequest(String courseID , String StudentID){
        return RestBean.success(service.submitCourseRequest(courseID,StudentID));
    }



}
