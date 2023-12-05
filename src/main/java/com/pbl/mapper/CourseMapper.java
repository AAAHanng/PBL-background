package com.pbl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbl.entity.dto.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {


        @Select("SELECT * FROM Course")

        List<Map<String, Object>> getCoursesForStudents();

        @Select("SELECT courseid, coursename, coursetime, location, maxcapacity, description FROM Course WHERE teacherID = #{teacher}")
        List<Map<String, Object>> getCourseByName(@Param("teacher") String teacher);

        @Select("SELECT User.studentID, User.username, User.college, User.classes , Course.coursename " +
                "FROM User " +
                "JOIN Enrollment ON User.studentID = Enrollment.studentID " +
                "JOIN Course ON Enrollment.courseID = Course.courseID " +
                "WHERE Course.teacher = #{teacher}AND User.Identification = 1")
        List<Map<String, Object>> getStudentInfo(@Param("teacher") String teacher);

        @Update("UPDATE Course SET description = #{description} WHERE courseid = #{courseId}")
        int updateCourseDescription(@Param("courseId") String courseId, @Param("description") String description);


        @Select("SELECT " +
                "U.username, " +
                "U.studentID, " +
                "U.classes, " +
                "C.coursename, " +
                "C.courseid, " +
                "E.Status " +
                "FROM Course C " +
                "JOIN Enrollment E ON C.courseid = E.courseid " +
                "JOIN User U ON E.studentid = U.studentID " +
                "WHERE C.teacherID = #{studentId}")
        List<Map<String, Object>> getUserCoursesWithStudentId(String studentID);

        @Select("SELECT " +
                "e.studentid, e.courseid, e.grade, e.Status, " +
                "c.coursename, c.location, c.coursetime, c.maxcapacity, c.description, c.credits, c.teacher " +
                "FROM Enrollment e " +
                "JOIN Course c ON e.courseid = c.courseid " +
                "WHERE e.studentid = #{studentID}")
        List<Map<String, Object>> getStudentCourseInfoByStudentID(String studentID);
}
