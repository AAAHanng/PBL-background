package com.pbl.controller;


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

@Validated
@RestController
@RequestMapping("/api/course")
@Tag(name = "课程相关", description = "包括课程信息 选课信息等")
public class CourseController {

    @Resource
    CourseService service;

    /**
     * 用户登录主页之后课程列表
     * @param // null
     * @return CourseVO对象
     */
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "测试成功"),
            @ApiResponse(responseCode = "500", description = "测试失败")   //不同返回状态码描述
    })
    @Operation(summary = "全部课程")   //接口功能描述
    @ResponseBody
    @GetMapping("/contact")
    public String contact(){

        return "hello world";
    }
}
