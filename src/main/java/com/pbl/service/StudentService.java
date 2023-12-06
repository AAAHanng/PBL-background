package com.pbl.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.Student;
import com.pbl.entity.vo.response.AccountVO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface StudentService extends IService<Student>, UserDetailsService {
    Student findAccountByNameOrEmail(String text);


    String updateInfo(String studentID, String phone, String email, String wechat, String qq, String bio);

    Student getContactByStudentID(String studentID);

    String putCourseRequest(String studentId, String teacherId, String courseId);

    List<Map<String,Object>> getAllCourse();

    List<Map<String, Object>> getTeacherClassList(String teacherId, int type);
}
