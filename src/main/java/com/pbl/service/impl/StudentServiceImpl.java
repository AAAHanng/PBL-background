package com.pbl.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.CourseRegistration;
import com.pbl.entity.dto.Student;
import com.pbl.entity.vo.response.AccountVO;
import com.pbl.mapper.CourseMapper;
import com.pbl.mapper.CourseRegistrationMapper;
import com.pbl.mapper.StudentMapper;
import com.pbl.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Resource
    CourseRegistrationMapper courseRegistrationMapper;

    @Resource
    CourseMapper courseMapper;

    /**
     * 从数据库中通过用户名或邮箱查找用户详细信息
     * @param username 用户名
     * @return 用户详细信息
     * @throws UsernameNotFoundException 如果用户未找到则抛出此异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student= this.findAccountByNameOrEmail(username);
        if(student == null)
            throw new UsernameNotFoundException("用户名或密码错误");
        return User
                .withUsername(username)
                .password(student.getPassWord())
                .build();
    }

    /**
     * 通过查找用户
     * @param text 用户名
     * @return 账户实体
     */
    public Student findAccountByNameOrEmail(String text){
        return this.query()
                .eq("studentId", text).or()
                .one();
    }

    @Override
    public String updateInfo(String studentID, String phone, String email, String wechat, String qq, String bio) {
        try {
                UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("studentID",studentID)
                        .set("phone", phone)
                        .set("email", email)
                        .set("wechat", wechat)
                        .set("qq", qq)
                        .set("bio",bio);
                studentMapper.update(null, updateWrapper);
                return "修改成功";
        } catch (Exception e) {
            return "修改失败";
        }
    }

    @Override
    public Student getContactByStudentID(String studentId) {
        return this.query().eq("studentId", studentId).one();
    }

    @Override
    public String putCourseRequest(String studentId, String teacherId, String courseId) {
        if (!enrollmentExists(studentId, courseId)) {
            CourseRegistration courseRegistration = new CourseRegistration(
                    null, studentId, teacherId, courseId, "等待");
            courseRegistrationMapper.insert(courseRegistration);
            return "插入成功";
        }else {
            return "已经选了";
        }
    }

    @Override
    public List<Map<String,Object>> getAllCourse() {
        return courseMapper.getAllCourse();
    }

    @Override
    public List<Map<String,Object>> getTeacherClassList(String studentId, int type) {
        List<Map<String, Object>> studentClassList = studentMapper.getStudentClassList(studentId);
        System.out.println(studentClassList);
        return studentClassList.stream()
                .filter(entity -> {
                    String status = (String) entity.get("status");
                    switch (type) {
                        case 0:
                            // 返回全部
                            return true;
                        case 1:
                            // 保留等待
                            return "等待".equals(status);
                        case 2:
                            // 保留已选课
                            return "已选课".equals(status);
                        default:
                            // 默认返回全部
                            return true;
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * 查看数据是否存在
     * @param // Studentid courseid
     * @return // boolean
     * */
    private boolean enrollmentExists(String studentID,String courseID) {
        // Query the database to check if the enrollment already exists
        QueryWrapper<CourseRegistration> selectWrapper = new QueryWrapper<>();
        selectWrapper.eq("studentId", studentID)
                .eq("courseId", courseID);
        CourseRegistration result = courseRegistrationMapper.selectOne(selectWrapper);
        return result != null;
    }
}











