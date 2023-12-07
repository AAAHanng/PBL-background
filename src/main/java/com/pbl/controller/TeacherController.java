package com.pbl.controller;


import com.pbl.entity.RestBean;
import com.pbl.entity.dto.HomeWork;
import com.pbl.entity.dto.Student;
import com.pbl.entity.dto.Teacher;
import com.pbl.service.HomeWorkService;
import com.pbl.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/teacher")
@Tag(name="老师端接口",description = "这些接口是服务老师")
public class TeacherController {

    @Resource
    TeacherService teacherService;

    @Resource
    HomeWorkService homeWorkService;

    /**
     * 用户根据工号来修改信息
     *
     * @param //request 请求工号 phone email wechat qq
     * @return RestBean 对象
     */
    @Operation(summary = "更新用户联系信息 根据工号(ps 修改老师的个人信息)", description = "更新用户的手机、邮件、微信和 QQ 号 ")
    @PutMapping("/updateInfo")
    public RestBean<Void> updateContactInfo(
            @RequestParam(name = "teacherId") String teacherId,
            @RequestParam(name = "phone", required = false) @Pattern(regexp = "^1[3456789]\\d{9}$") String phone,
            @RequestParam(name = "email", required = false) @Email String email,
            @RequestParam(name = "wechat", required = false) String wechat,
            @RequestParam(name = "qq", required = false) @Pattern(regexp = "^[0-9]{5,12}$") String qq,
            @RequestParam(name = "bio", required = false) String bio
    ) {
        String message = teacherService.updateInfo(teacherId, phone, email, wechat, qq, bio);
        return (message == null) ? RestBean.failure(401, "更改信息失败") : RestBean.success();
    }

    /**
     * 用户登录主页之后根据工号进入系统
     *
     * @param //request 请求学号
     * @return AccountVO对象
     */
    @Operation(summary = "用户登录主页之后根据工号进入系统 查看到qq等信息")   //接口功能描述
    @ResponseBody
    @GetMapping("/getContact")
    public RestBean<Teacher> getContact(@RequestParam String teacherId) {
        // 调用服务类的方法获取数据
        Teacher data = teacherService.getContactByStudentID(teacherId);
        if (data == null) return RestBean.failure(400, "没有该用户");
        // 返回一个成功的 RestBean 对象
        return RestBean.success(data);
    }

    /**
     * 老师根据工号 关联CourseRegistration 得到学生学号 学号再去User表查询
     *
     * @param //request 请求工号
     * @return RestBean
     */
    @Operation(summary = "老师根据工号 查询有哪些人选了课 (ps 查询申请该老师下面课程的申请学生)", description =
            "type参数为1 返回该老师等待选课的列表 ，" +
                    "type参数为2 返回该老师已经同一选课的列表，" +
                    "type参数0 默认返回该是老师所有 列表 ")   //接口功能描述
    @ResponseBody
    @GetMapping("/getTeacherClassList")
    public RestBean<List<Map<String, Object>>> getTeacherClassList(@RequestParam(name = "teacherId") String teacherId,
                                                                   @RequestParam(required = false) int type
    ) {
        // 调用服务类的方法获取数据
        List<Map<String, Object>> data = teacherService.getTeacherClassList(teacherId, type);
        if (data == null) return RestBean.failure(400, "没有该用户");
        // 返回一个成功的 RestBean 对象
        return RestBean.success(data);
    }

    /**
     * 老师根据工号  teacherId 关联CourseTeacher 查询课表
     *
     * @param //request 请求工号
     * @return RestBean
     */
    @Operation(summary = "老师根据工号 查询自己有什么课 ")   //接口功能描述
    @ResponseBody
    @GetMapping("/getTeacherHasClassList")
    public RestBean<List<Map<String, Object>>> getTeacherHasClassList(@RequestParam(name = "teacherId") String teacherId) {
        // 调用服务类的方法获取数据
        List<Map<String, Object>> data = teacherService.getTeacherHasClassList(teacherId);
        if (data == null) return RestBean.failure(400, "没有该用户");
        // 返回一个成功的 RestBean 对象
        return RestBean.success(data);
    }

    /**
     * 待定 ============================
     * 老师根据工号  teacherId 关联CourseTeacher 查询课表
     *
     * @param //request 请求工号
     * @return RestBean
     */
    @Operation(summary = "老师根据工号 查询自己有学生(查询改老师下面的所有学生)")   //接口功能描述
    @ResponseBody
    @GetMapping("/getStudentListByTeacherId")
    public RestBean<List<Map<String, Object>>> getStudentListByTeacherId(@RequestParam(name = "teacherId") String teacherId) {
        // 调用服务类的方法获取数据
        List<Map<String, Object>> data = teacherService.getStudentListByTeacherId(teacherId);
        if (data == null) return RestBean.failure(400, "没有该用户");
        // 返回一个成功的 RestBean 对象
        return RestBean.success(data);
    }

    /**
     * 老师根据工号  teacherId 关联CourseTeacher 查询课表
     *
     * @param //request 请求工号
     * @return RestBean
     */
    @Operation(summary = "老师根据工号 学生Id 课程id 确认该门课 是否同一",
            description = "type参数为1 则同一 ，" +
                    "type参数为0 则不同意，ps(也可以自己设定值)")   //接口功能描述
    @ResponseBody
    @PutMapping("/updateClassStatus")
    public RestBean<String> updateClassStatus(
            @RequestParam(name = "teacherId") String teacherId,
            @RequestParam(name = "courseId") String courseId,
            @RequestParam(name = "studentId") String studentId,
            @RequestParam(name = "type") String type
    ) {
        // 调用服务类的方法获取数据
        String data = teacherService.updateClassStatus(teacherId, courseId, type,studentId);
        return RestBean.success(data);
    }

    /**
     * 给指定一个课程布置一项作业
     *
     * @param //request 请求工号 课程Id 班级id 作业名字 作业描述
     * @return RestBean
     */
    @Operation(summary = "请求工号 课程Id 班级id 作业名字 作业描述   返回是否成功")   //接口功能描述
    @ResponseBody
    @PutMapping("/putHomeWork")
    public RestBean<String> putHomeWork(
            @RequestParam(name = "teacherId") String teacherId,
            @RequestParam(name = "courseId") String courseId,
            @RequestParam(name = "classId") String classId,
            @RequestParam(name = "homeWorkName") String homeWorkName,
            @RequestParam(name = "description") String description
    ) {
        // 调用服务类的方法获取数据
        String data = homeWorkService.putHomeWork(teacherId, courseId, classId,homeWorkName,description);
        return RestBean.success(data);
    }


    /**
     * 通过老师id和课程id查询下面布置的作业
     *
     * @param //request 请求工号 课程Id
     * @return RestBean
     */
    @Operation(summary = "请求工号 课程Id 查询下面布置的作业  返回实体类")   //接口功能描述
    @ResponseBody
    @GetMapping("/getHomeWorkByTeacherIdAndClassID")
    public RestBean<List<HomeWork>> getHomeWorkByTeacherIdAndClassID(
            @RequestParam(name = "teacherId") String teacherId,
            @RequestParam(name = "courseId") String courseId
    ) {
        List<HomeWork> data=  homeWorkService.getHomeWorkByTeacherIdAndClassID(teacherId, courseId);
        return (data == null) ? RestBean.failure(400,"没找到该用户") : RestBean.success(data);
    }

    /**
     * 通过老师id和课程id 还有作业id查询有那些作业
     *
     * @param //request 请求工号 课程Id
     * @return RestBean
     */
    @Operation(summary = "可以直接通过 作业id查询有那些作业 ps(不小心设为唯一值了) ")   //接口功能描述
    @ResponseBody
    @GetMapping("/getHomeWorkByCourseId")
    public RestBean<HomeWork> getHomeWorkByTeacherIdAndClassID(
            @RequestParam(name = "homeWorkId") String homeWorkId
    ) {
        HomeWork data=  homeWorkService.getHomeWorkByTeacherIdAndClassIDAndCourseId(homeWorkId);
        return (data == null) ? RestBean.failure(400,"没找到该用户") : RestBean.success(data);
    }

    /**
     * 通过作业id批改分数
     * @param //request 请求工号 课程Id
     * @return RestBean
     */
    @Operation(summary = "可以直接通过 作业id批改分数 ps(不小心设为唯一值了)  返回是否成功")   //接口功能描述
    @ResponseBody
    @PutMapping("/updateHomWorkGrade")
    public RestBean<String> updateHomWorkGrade(
            @RequestParam(name = "homeWorkId") String homeWorkId,
            @RequestParam(name = "Grade") String Grade
    ) {
        String data=  homeWorkService.updateHomWorkGrade(homeWorkId,Grade);
        return (data == null) ? RestBean.failure(400,"没找到该用户") : RestBean.success(data);
    }
}