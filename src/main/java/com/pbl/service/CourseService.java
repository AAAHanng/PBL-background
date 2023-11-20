package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Course;

import java.util.List;

public interface CourseService extends IService<Course>{

    List FindAllCourse();

    List <Course> FindALCourse(String StudentID);

    Void submitCourseRequest(String courseID, String studentID);

    Void deleteEnrollment(String studentId, String courseId);

    Void updateStatus(String studentId, String courseId);
}
