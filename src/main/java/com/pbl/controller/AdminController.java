package com.pbl.controller;

import com.pbl.entity.RestBean;
import com.pbl.entity.dto.Admin;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.Student;
import com.pbl.entity.dto.Teacher;
import com.pbl.service.AdminService;
import com.pbl.service.CourseService;
import com.pbl.service.StudentService;
import com.pbl.service.TeacherService;
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

    @Resource
    StudentService studentService;

    @Resource
    TeacherService teacherService;

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
    @PutMapping("/addCourse")
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
    @PutMapping("/DeleteCourse")
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
    @PutMapping("/updateCourse")
    public RestBean<String> updateCourse(@RequestBody Course course) {
        // 调用服务类的方法获取数据
        String data = courseService.updateCourse(course);
        return RestBean.success(data);
    }

    /**
     * 管理员 账号管理
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员 账号管理 学生 增加" )   //接口功能描述
    @ResponseBody
    @PutMapping("/addStudent")
    public RestBean<String> addStudent(@RequestBody Student student) {
        // 调用服务类的方法获取数据
        String data = studentService.addStudent(student);
        return RestBean.success(data);
    }

    /**
     * 管理员 账号管理
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员 账号管理 学生 删除" )   //接口功能描述
    @ResponseBody
    @GetMapping("/deleteStudent")
    public RestBean<String> deleteStudent(@RequestBody String studentId) {
        // 调用服务类的方法获取数据
        String data = studentService.deleteStudent(studentId);
        return RestBean.success(data);
    }

    /**
     * 管理员 更爱学生
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员 账号管理 学生 更改" )   //接口功能描述
    @ResponseBody
    @PutMapping("/updateStudent")
    public RestBean<String> updateStudent(@RequestBody Student student) {
        // 调用服务类的方法获取数据
        String data = studentService.updateStudent(student);
        return RestBean.success(data);
    }

    /**
     * 管理员 获取学生表
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员 获取学生表" )   //接口功能描述
    @ResponseBody
    @GetMapping("/getStudent")
    public RestBean<List<Student>> getStudent() {
        // 调用服务类的方法获取数据
        List<Student> data = studentService.getStudent();
        return RestBean.success(data);
    }

    /**
     * 管理员 账号管理
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员 账号管理 老师 增加" )   //接口功能描述
    @ResponseBody
    @PutMapping("/addTeacher")
    public RestBean<String> addTeacher(@RequestBody Teacher teacher) {
        // 调用服务类的方法获取数据
        String data = teacherService.addTeacher(teacher);
        return RestBean.success(data);
    }

    /**
     * 管理员 账号管理
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员 账号管理 Teacher 删除" )   //接口功能描述
    @ResponseBody
    @PutMapping("/deleteTeacher")
    public RestBean<String> deleteTeacher(@RequestBody String teacherId) {
        // 调用服务类的方法获取数据
        String data = teacherService.deleteTeacher(teacherId);
        return RestBean.success(data);
    }

    /**
     * 管理员 更爱学生
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员 账号管理 Teacher 更改" )   //接口功能描述
    @ResponseBody
    @PutMapping("/updateTeacher")
    public RestBean<String> updateTeacher(@RequestBody Teacher student) {
        // 调用服务类的方法获取数据
        String data = teacherService.updateStudent(student);
        return RestBean.success(data);
    }

    /**
     * 管理员 获取学生表
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "管理员 获取Teacher表" )   //接口功能描述
    @ResponseBody
    @GetMapping("/getTeacher")
    public RestBean<List<Teacher>> getTeacher() {
        // 调用服务类的方法获取数据
        List<Teacher> data = teacherService.getTeacher();
        return RestBean.success(data);
    }
}









