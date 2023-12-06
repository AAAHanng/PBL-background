package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AAAHang
 * @since 2023-12-05
 */
@AllArgsConstructor
@Data
@TableName("CourseRegistration")
public class CourseTeacher implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 选课ID，唯一标识每次选课
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 老师ID，关联到 user_teacher 表
     */
    @TableField("teacherId")
    private String teacherID;

    /**
     * 课程ID，关联到 Course 表
     */
    @TableField("courseId")
    private String courseID;

    @Override
    public String toString() {
        return "CourseRegistration{" +
        ", teacherID = " + teacherID +
        ", courseID = " + courseID +
        "}";
    }
}
