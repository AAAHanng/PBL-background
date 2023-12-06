package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

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
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 课程ID，唯一标识课程
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程ID，唯一标示
     */
    @TableField("courseId")
    private String courseId;

    /**
     * 课程名称
     */
    @TableField("courseName")
    private String courseName;

    /**
     * 课程地点
     */
    private String location;

    /**
     * 课程时间
     */
    @TableField("courseTime")
    private String courseTime;

    /**
     * 课程人数上限
     */
    @TableField("maxCapacity")
    private Integer maxCapacity;

    /**
     * 课程简介
     */

    private String description;

    /**
     * 学分
     */
    private Integer credits;

    /**
     * 授课老师
     */
    private String teacher;

    private String classes;
    @Override
    public String toString() {
        return "Course{" +
        "id = " + id +
        ", courseId = " + courseId +
        ", courseName = " + courseName +
        ", location = " + location +
        ", courseTime = " + courseTime +
        ", maxCapacity = " + maxCapacity +
        ", description = " + description +
        ", credits = " + credits +
        ", teacher = " + teacher +
        "}";
    }
}
