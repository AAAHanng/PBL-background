package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AAAHang
 * @since 2023-12-05
 */
@TableName("FileRegistration")
public class FileRegistration implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件ID，唯一标识每次选课
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
     * 文件ID，关联到 file 表
     */
    private Integer fileID;

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

    public Integer getFileID() {
        return fileID;
    }

    public void setFileID(Integer fileID) {
        this.fileID = fileID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FileRegistration{" +
        "registrationID = " + registrationID +
        ", studentID = " + studentID +
        ", teacherID = " + teacherID +
        ", fileID = " + fileID +
        ", status = " + status +
        "}";
    }
}
