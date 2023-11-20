package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author AAAhang
 * @since 2023-10-26
 */
@AllArgsConstructor
@TableName("Enrollment")
@Data
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 选课ID，唯一标识选课记录
     */
    @TableId(value = "EnrollmentID", type = IdType.AUTO)
    private Integer enrollmentID;

    /**
     * 学生ID，关联到User表的UserID
     */
    @TableField(value = "studentid")
    private String studentID;

    /**
     * 课程ID，关联到Course表的CourseID
     */
    @TableField(value = "courseid")
    private String courseID;

    /**
     * 选课日期
     */
    @TableField(value = "enrollmentDate")
    private LocalDateTime enrollmentDate;

    /**
     * 成绩
     */
    private Integer grade;

    @TableField(value = "Status")
    private String Status;
}
