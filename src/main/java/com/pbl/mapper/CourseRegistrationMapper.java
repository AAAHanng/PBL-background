package com.pbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.CourseRegistration;
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
public interface CourseRegistrationMapper extends BaseMapper<CourseRegistration> {

    @Select("SELECT h.homeWorkName, c.courseName " +
            "FROM CourseRegistration cr " +
            "JOIN Course c ON cr.courseId = c.courseId " +
            "JOIN HomeWorkRegistration hr ON cr.teacherId = hr.teacherId " +
            "JOIN HomeWork h ON hr.homeWorkId = h.homeWorkId " +
            "WHERE cr.teacherId = #{teacherId}")
    List<Map<String,Object>> getCourseAndHomeWorkName(String studentId);
}
