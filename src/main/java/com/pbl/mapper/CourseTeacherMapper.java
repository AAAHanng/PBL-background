package com.pbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.CourseTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseTeacherMapper extends BaseMapper<CourseTeacher> {

    @Select("SELECT Course.courseId, Course.courseName, Course.courseTime, " +
            "Course.description, Course.location, Course.maxCapacity, CourseTeacher.teacherId " +
            "FROM Course " +
            "INNER JOIN CourseTeacher ON Course.courseId = CourseTeacher.courseId " +
            "WHERE CourseTeacher.teacherId = #{teacherId}")
    List<Map<String, Object>> getTeacherHasClassList(@Param("teacherId") String teacherId);
}
