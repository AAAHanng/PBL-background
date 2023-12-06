package com.pbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.Student;
import org.apache.ibatis.annotations.Mapper;
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
public interface StudentMapper extends BaseMapper<Student> {

    @Select("SELECT " +
            "t.userName, t.studentId, t.classes, t.college, " +
            "c.courseId, c.courseName, c.courseTime, c.description, " +
            "c.credits, c.location, c.teacher ,cr.status " +
            "FROM user_student t " +
            "JOIN CourseRegistration cr ON t.studentId = cr.studentID " +
            "JOIN Course c ON cr.CourseID = c.courseId " +
            "WHERE t.studentId = #{studentId}")
    List<Map<String, Object>> getStudentClassList(String studentId);
}
