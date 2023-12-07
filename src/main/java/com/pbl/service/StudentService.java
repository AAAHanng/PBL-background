package com.pbl.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Student;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface StudentService extends IService<Student>, UserDetailsService {


    String addStudent(Student student);

    Student findAccountByNameOrEmail(String text);

    String updateInfo(String studentID, String phone, String email, String wechat, String qq, String bio);

    Student getContactByStudentID(String studentID);

    String putCourseRequest(String studentId, String teacherId, String courseId);

    List<Map<String,Object>> getAllCourse();

    List<Map<String, Object>> getTeacherClassList(String teacherId, int type);

    String deleteStudent(String studentId);

    String updateStudent(Student student);

    List<Student> getStudent();
}
