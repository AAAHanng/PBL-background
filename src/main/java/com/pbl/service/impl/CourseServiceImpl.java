package com.pbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.Enrollment;
import com.pbl.mapper.CourseMapper;
import com.pbl.mapper.EnrollmentMapper;
import com.pbl.service.CourseService;
import com.pbl.utils.Const;
import jakarta.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    EnrollmentMapper enrollmentMapper;

    @Resource
    CourseMapper courseMapper;

    @Resource
    AmqpTemplate rabbitTemplate;

    @Override
    public List FindAllCourse() {
        List<Course> list = courseMapper.selectList(null);
        if (list == null) return Collections.singletonList("查无数据");
        return list;
    }

    @Override
    public List<Course> FindALCourse(String studentID) {
        // 查询符合条件的 Enrollment 记录
        QueryWrapper<Enrollment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("StudentID", studentID);
        List<Enrollment> enrollments = enrollmentMapper.selectList(queryWrapper);

        if (enrollments.isEmpty()) {
            // 如果没有符合条件的 Enrollment 记录，可以根据实际情况处理，例如返回空列表或抛出异常
            return null;
        }

        // 提取 CourseID 列表
        List<String> courseIds = enrollments.stream().map(Enrollment::getCourseID).collect(Collectors.toList());

        // 查询符合条件的 Course 记录
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.in("CourseID", courseIds);
        return courseMapper.selectList(courseQueryWrapper);
    }


    @Override
    public Void submitCourseRequest(String courseID, String studentID) {
        Course Grade = this.query()
                .eq("courseid", courseID)
                .one();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Enrollment enrollment = new Enrollment(
                null, studentID, courseID, currentDateTime, Grade.getCredits(), "等待"
        );
        enrollmentMapper.insert(enrollment);
        Map<String, Object> data = Map.of("courseID", courseID, "studentID", studentID);
        rabbitTemplate.convertAndSend(Const.COURSE_REQUEST, data);
        return null;
    }

    public Void deleteEnrollment(String studentId, String courseId) {
        try {
            QueryWrapper<Enrollment> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("StudentID", studentId).eq("CourseID", courseId);
            int deletedRows = enrollmentMapper.delete(queryWrapper);

            if (deletedRows > 0) {
                System.out.println("删除成功.");
            } else {
                System.out.println("没有匹配的数据.");
            }
        } catch (Exception e) {
            System.err.println("错误删除: " + e.getMessage());
            e.printStackTrace(); // 打印异常堆栈信息
        }
        return null;
    }


    public Void updateStatus(String studentId, String courseId){
        try {
            // 创建更新条件
            UpdateWrapper<Enrollment> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("StudentID", studentId)
                    .eq("courseID", courseId);
            // 执行更新操作
            int rowsAffected = enrollmentMapper.update(null, updateWrapper.set("status", "成功选课"));

            if (rowsAffected > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败，未找到符合条件的记录");
            }
        } catch (Exception e) {
            System.err.println("错误删除: " + e.getMessage());
            e.printStackTrace(); // 打印异常堆栈信息
        }
        return null;
    }
}

