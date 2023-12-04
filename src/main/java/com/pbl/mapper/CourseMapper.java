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


        @Select("SELECT Course.courseid ,Course.teacher, Course.coursename, Course.coursetime, Course.location, User.classes " +
                "FROM Course " +
                "LEFT JOIN Enrollment ON Course.CourseID = Enrollment.CourseID " +
                "LEFT JOIN User ON Enrollment.StudentID = User.studentID " +
                "WHERE User.Identification = 1")

        List<Map<String, Object>> getCoursesForStudents();

        @Select("SELECT coursename, coursetime, location, maxcapacity, description FROM Course WHERE teacher = #{teacher}")
        List<Map<String, Object>> getCourseByName(@Param("teacher") String teacher);

        @Select("SELECT User.studentID, User.username, User.college, User.classes , Course.coursename " +
                "FROM User " +
                "JOIN Enrollment ON User.studentID = Enrollment.studentID " +
                "JOIN Course ON Enrollment.courseID = Course.courseID " +
                "WHERE Course.teacher = #{teacher}AND User.Identification = 1")
        List<Map<String, Object>> getStudentInfo(@Param("teacher") String teacher);

        @Update("UPDATE Course SET description = #{description} WHERE courseid = #{courseId}")
        int updateCourseDescription(@Param("courseId") String courseId, @Param("description") String description);


        @Select("SELECT U.username, U.studentID, U.classes, C.coursename, C.courseid, E.Status " +
                "FROM User U " +
                "JOIN (" +
                "   SELECT EC.StudentID, EC.CourseID, EC.Status " +
                "   FROM (" +
                "       SELECT E.StudentID, E.CourseID, E.Status " +
                "       FROM Enrollment E " +
                "       WHERE E.courseID IN (" +
                "           SELECT CourseID " +
                "           FROM Enrollment " +
                "           WHERE studentID = #{studentID}" +
                "       )" +
                "   ) AS EC" +
                ") AS E ON U.studentID = E.StudentID " +
                "JOIN Course C ON E.CourseID = C.CourseID " +
                "WHERE U.identification = 1")
        List<Map<String, Object>> getUserCoursesWithStudentId(String studentID);

        @Select("SELECT " +
                "e.studentid, e.courseid, e.grade, e.Status, " +
                "c.coursename, c.location, c.coursetime, c.maxcapacity, c.description, c.credits, c.teacher " +
                "FROM Enrollment e " +
                "JOIN Course c ON e.courseid = c.courseid " +
                "WHERE e.studentid = #{studentID}")
        List<Map<String, Object>> getStudentCourseInfoByStudentID(String studentID);
}
