package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Course;

import java.util.List;
import java.util.Map;

public interface CourseService extends IService<Course>{

    List FindAllCourse();

    List <Course> FindALCourse(String StudentID);

    String submitCourseRequest(String courseID, String studentID);

    List<Map<String, Object>> TeacherClassList(String courseID,String type);

    String TeacherChange(String studentID, String courseID , String type);
    String createCourse(Course course);


    Course getCourseById(String courseId);


    String updateCourse(Course course);


    String deleteCourse(String courseId);

    List<Map<String, Object>> getCoursesForStudents();

    List<Map<String, Object>> getCourses(String username);

    List<Map<String, Object>> getStudentInfo(String teacher);

    String updateCourseDescription(String courseid ,String description);

    List<Map<String, Object>> getRequestList(String studentID);

}
