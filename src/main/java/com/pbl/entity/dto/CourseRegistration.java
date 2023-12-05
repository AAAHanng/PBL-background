package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AAAHang
 * @since 2023-12-05
 */
public class CourseRegistration implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 选课ID，唯一标识每次选课
     */
    @TableId(value = "registrationID", type = IdType.AUTO)
    private Integer registrationID;

    /**
     * 学生ID，关联到 user_student 表
     */
    private String studentID;

    /**
     * 老师ID，关联到 user_teacher 表
     */
    private String teacherID;

    /**
     * 课程ID，关联到 Course 表
     */
    private Integer courseID;

    /**
     * 状态
     */
    private String status;

    public Integer getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(Integer registrationID) {
        this.registrationID = registrationID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseRegistration{" +
        "registrationID = " + registrationID +
        ", studentID = " + studentID +
        ", teacherID = " + teacherID +
        ", courseID = " + courseID +
        ", status = " + status +
        "}";
    }
}
