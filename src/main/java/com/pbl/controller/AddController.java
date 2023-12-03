package com.pbl.controller;

import com.pbl.entity.RestBean;
import com.pbl.service.AccountService;
import com.pbl.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/add")
@Tag(name = "添加接口", description = "新接口都看这里")
public class AddController {
    @Resource
    CourseService courseService;

    @Resource
    AccountService accountService;

    /**
     * 所有课程库
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "所有课程库  赵wl",description = "赵wl")   //接口功能描述
    @ResponseBody
    @GetMapping("/getCoursesForStudents")
    public  List<Map<String, Object>> getCoursesForStudents(){

        return courseService.getCoursesForStudents();
    }

    /**
     * 所有课程库
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "课程-课程管理 谢lf",description = "谢lf  输入为老师姓名")   //接口功能描述
    @ResponseBody
    @PostMapping("/getCourses")
    public  List<Map<String, Object>> getCourses( String teacher){

        return courseService.getCourses(teacher);
    }

    /**
     * 所有课程库
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "学生信息 谢lf",description = "谢lf  输入为老师姓名")   //接口功能描述
    @ResponseBody
    @PostMapping("/getStudentInfo")
    public  List<Map<String, Object>> getStudentInfo(String teacher){

        return courseService.getStudentInfo(teacher);
    }

    /**
     * 所有课程库
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "学生信息 谢lf",description = "谢lf  输入为老师姓名")   //接口功能描述
    @ResponseBody
    @PostMapping("/updateCourseDescription")
    public RestBean<String> updateCourseDescription(String courseid, String Description){
        return RestBean.success(courseService.updateCourseDescription(courseid ,Description));
    }

    /**
     * 所有课程库
     *
     * @param // null
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "申请列表 谢lf",description = "谢lf  输入为老师id")   //接口功能描述
    @ResponseBody
    @GetMapping("/getRequestList")
    public RestBean<List<Map<String, Object>>> getRequestList(HttpServletRequest request){
        String teacherID=request.getParameter("teacherID");
        return RestBean.success(courseService.getRequestList(teacherID));
    }
}