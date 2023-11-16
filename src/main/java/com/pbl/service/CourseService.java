package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Course;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CourseService extends IService<Course>, UserDetailsService {

    Course FindAllCourse();
}
