package com.pbl.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.Course;
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
public interface CourseMapper extends BaseMapper<Course> {

    @Select("SELECT c.*, cr.Status AS RegistrationStatus, ct.TeacherID " +
            "FROM Course c " +
            "LEFT JOIN CourseRegistration cr ON c.CourseID = cr.CourseID " +
            "LEFT JOIN CourseTeacher ct ON c.CourseID = ct.CourseID")
    List<Map<String,Object>> getAllCourse();
}
