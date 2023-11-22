package com.pbl.controller;

import com.pbl.entity.RestBean;
import com.pbl.entity.dto.Account;
import com.pbl.entity.dto.Course;
import com.pbl.service.AccountService;
import com.pbl.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/admin")
@Tag(name = "管理员端口", description = "增删改查")
public class AdminController {

    @Resource
    CourseService courseService;

    @Resource
    AccountService accountService;
    /**
     * 管理员添加课程表
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "增加课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/createCourse")
    public RestBean<String> createCourse(@RequestBody Course course){
        System.out.println(course);
        return RestBean.success(courseService.createCourse(course));
    }

    /**
     * 管理员查询课程表
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "查课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/getCourse")
    public RestBean<Course> getCourseById(String courseID){
        return RestBean.success(courseService.getCourseById(courseID));
    }

    /**
     * 管理员更新课程表
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "更新课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/updateCourse")
    public RestBean<String> updateCourse( @RequestBody Course course){
        return RestBean.success(courseService.updateCourse(course));
    }

    /**
     * 管理员删除课程表
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "删除课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/deleteCourse")
    public RestBean<String> deleteCourse(String courseId){
        return RestBean.success(courseService.deleteCourse(courseId));
    }

    /**
     * 管理员添加User表
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "增加课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/createUser")
    public RestBean<String> createCourse(@RequestBody Account account){
        return RestBean.success(accountService.createUser(account));
    }

    /**
     * 管理员查询Userbyid
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "查课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/getUser")
    public RestBean<Account> getUserById(String studentID){
        System.out.println(studentID);
        return RestBean.success(accountService.getUserById(studentID));
    }

    /**
     * 管理员更新User
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "更新课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/updateUser")
    public RestBean<String> updateUser( @RequestBody Account account){
        return RestBean.success(accountService.updateUser(account));
    }

    /**
     * 管理员删除用户吧
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "删除课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/deleteUser")
    public RestBean<String> deleteUser(String studentID){
        System.out.println(studentID);
        System.out.println("121314");
        return RestBean.success(accountService.deleteUser(studentID));
    }


}
