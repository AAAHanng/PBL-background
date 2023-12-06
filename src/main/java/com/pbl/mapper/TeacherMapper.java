package com.pbl.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AAAHang
 * @since 2023-12-05
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {


    @Select("SELECT " +
            "u.userName, " +
            "u.studentId, " +
            "u.classes, " +
            "u.college, " +
            "c.courseId, " +
            "c.courseName, " +
            "cr.`status` " +
            "FROM " +
            "user_teacher t " +
            "JOIN CourseRegistration cr ON t.teacherId = cr.teacherID " +
            "JOIN Course c ON cr.CourseID = c.Id " +
            "JOIN user_student s ON cr.StudentID = s.studentId " +
            "JOIN user_student u ON s.userID = u.userID " +
            "WHERE " +
            "t.teacherId = #{teacherId}")
    List<Map<String,Object>>  getTeacherClassList(@Param("teacherId") String teacherId);
}
