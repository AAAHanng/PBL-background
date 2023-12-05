package com.pbl.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.pbl.entity.dto.Course;
import com.pbl.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.HsqlTableMetaDataProvider;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teacher")
@Validated
@Tag(name="老师端接口",description = "这些接口是用来老师端辅助的")
public class TeacherController {

    @Resource
    CourseService courseService;


    /**
     * 老师确定收到学生的选课列表
     *
     * @param // StudentID
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "老师确定收到学生的选课列表",description = "type")   //接口功能描述
    @ResponseBody
    @PostMapping("/CourseRequest")
    public List<Map<String, Object>> TeacherClassList(String courseID , String type){
        return courseService.TeacherClassList(courseID,type);
    }

    /**
     * 老师确定是否该学生选课
     *
     * @param // StudentID
     * @return 课程对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "老师确定收到学生的选课列表",description = "type")   //接口功能描述
    @ResponseBody
    @GetMapping("/isCourseRequest")
    public String TeacherChange(String studentID, String courseID , String type){
        return courseService.TeacherChange(studentID,courseID,type);
    }

}
