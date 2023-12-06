package com.pbl.controller;


import com.pbl.entity.RestBean;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.Student;
import com.pbl.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@Validated
@Tag(name="学生端接口",description = "这些接口是服务学生")
public class StudentController {

    @Resource
    StudentService studentService;

    /**
     * 用户根据学号来修改信息
     * @param //request 请求学号  phone email wechat qq
     * @return RestBean 对象
     */
    @Operation(summary = "更新用户联系信息 根据学号", description = "更新用户的手机、邮件、微信和 QQ 号 ")
    @PutMapping("/updateInfo")
    public RestBean<Void> updateContactInfo(
            @RequestParam(name = "studentId") String studentId,
            @RequestParam(name = "phone" ,required = false) @Pattern(regexp = "^1[3456789]\\d{9}$") String phone,
            @RequestParam(name = "email", required = false) @Email String email,
            @RequestParam(name = "wechat", required = false) String wechat,
            @RequestParam(name = "qq", required = false) @Pattern(regexp = "^[0-9]{5,12}$") String qq,
            @RequestParam(name = "bio", required = false) String bio
    ) {
        String message = studentService.updateInfo(studentId, phone, email, wechat, qq,bio);
        return (message == null) ? RestBean.failure(401, "更改信息失败") : RestBean.success();
    }

    /**
     * 用户登录主页之后根据学号进入系统
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "用户登录主页之后根据学号进入系统 查看到qq等信息" )   //接口功能描述
    @ResponseBody
    @GetMapping("/getContact")
    public RestBean<Student> getContact(@RequestParam String studentId) {
        // 调用服务类的方法获取数据
        Student data = studentService.getContactByStudentID(studentId);
        if (data == null) return RestBean.failure(400,"没有该用户");
        // 返回一个成功的 RestBean 对象
        return RestBean.success(data);
    }

    /**
     * 学生发送请求课程
     * @param //request 请求学号 老师工号 课程号
     * @return AccountVO对象
     */
    @Operation(summary = "学生发送请求课程  请求学号 老师工号 课程号" )   //接口功能描述
    @ResponseBody
    @PostMapping("putCourseRequest")
    public RestBean<String> putCourseRequest(@RequestParam String studentId,
                                              @RequestParam String teacherId,
                                              @RequestParam String courseId
    ) {
        String data = studentService.putCourseRequest(studentId,teacherId,courseId);
        return RestBean.success(data);
    }

    /**
     * 学生返回可以选的课
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "学生返回可以选的课" )   //接口功能描述
    @ResponseBody
    @GetMapping("/getAllCourse")
    public RestBean<List<Map<String,Object>>> getAllCourse() {
        return RestBean.success(studentService.getAllCourse());
    }

    /**
     * 学生根据学号 关联CourseRegistration 得到学生学号 学号再去User表查询
     *
     * @param //request 请求工号
     * @return RestBean
     */
    @Operation(summary = "学生根据学号 查询有哪些人选了课", description =
            "type参数为1 返回该学生等待选课的列表 ，" +
                    "type参数为2 返回该学生已经选课的列表，" +
                    "type参数0 默认返回该是学生所有 列表 ")   //接口功能描述
    @ResponseBody
    @GetMapping("/getStudentClassListByStudentID")
    public RestBean<List<Map<String, Object>>> getStudentClassListByStudentID(@RequestParam(name = "studentId") String studentId,
                                                                   @RequestParam(required = false) int type
    ) {
        List<Map<String, Object>> data = studentService.getTeacherClassList(studentId, type);
        if (data == null) return RestBean.failure(400, "没有该用户");
        return RestBean.success(data);
    }
}
