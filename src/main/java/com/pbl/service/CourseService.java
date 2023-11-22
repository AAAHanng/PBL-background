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

}
