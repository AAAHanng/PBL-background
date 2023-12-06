package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Course;

import java.util.List;
import java.util.Map;

public interface CourseService extends IService<Course> {
    String addCourse(Course course);

    String deleteCourse(String courseId);

    String updateCourse(Course course);
}
