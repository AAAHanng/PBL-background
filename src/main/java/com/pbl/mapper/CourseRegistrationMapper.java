package com.pbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.CourseRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT c.courseName, h.homeWorkName " +
            "FROM Course c " +
            "JOIN CourseRegistration cr ON c.courseId = cr.courseId " +
            "JOIN HomeWork h ON cr.homeWorkId = h.homeWorkId " +
            "WHERE cr.studentId = #{studentId}")
    String getCourseAndHomeWorkName(String studentId);
}
