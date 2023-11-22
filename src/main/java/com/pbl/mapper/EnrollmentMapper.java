package com.pbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.Enrollment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EnrollmentMapper extends BaseMapper<Enrollment> {

    @Select("SELECT " +
            "Enrollment.EnrollmentID, " +
            "User.Username AS StudentUsername, " +
            "Enrollment.Grade, " +
            "Enrollment.Status," +
            "Course.CourseID, " +
            "Course.CourseName, " +
            "Course.Location, " +
            "Course.CourseTime, " +
            "Course.Credits, " +
            "Course.Teacher " +
            "FROM " +
            "Enrollment " +
            "JOIN " +
            "User ON Enrollment.StudentID = User.studentid " +
            "JOIN " +
            "Course ON Enrollment.CourseID = Course.CourseID " +
            "WHERE " +
            "Enrollment.CourseID = #{courseId}")
    List<Map<String, Object>>getEnrollmentsByCourseId(@Param("courseId") String courseId);


}
