package com.pbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.Admin;
import com.pbl.entity.dto.Course;
import com.pbl.mapper.AdminMapper;
import com.pbl.mapper.CourseMapper;
import com.pbl.service.AdminService;
import com.pbl.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    CourseMapper courseMapper;

    @Override
    public String addCourse(Course course) {
        try {
            this.save(course);
            return "课程创建成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程创建失败，可能出现错误：";
        }

    }

    @Override
    public String deleteCourse(String courseId) {
        try {
            QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("courseId",courseId);
            courseMapper.delete(queryWrapper);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程删除失败，可能出现错误：" ;
        }
    }

    @Override
    public String updateCourse(Course course) {
        try {
            this.updateById(course);
            return "课程更新成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程更新失败，可能出现错误：";
        }
    }
}
