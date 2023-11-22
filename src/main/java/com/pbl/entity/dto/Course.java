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
@Data
@TableName("Course")
@AllArgsConstructor
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程ID，唯一标识课程
     */
    @TableId(value = "courseid", type = IdType.AUTO)
    private Integer courseID;

    /**
     * 课程名称
     */
    @TableField(value = "CourseName")
    private String courseName;

    /**
     * 课程地点
     */
    private String location;

    /**
     * 课程时间
     */
    @TableField(value = "CourseTime")
    private String courseTime;

    /**
     * 课程人数上限
     */
    @TableField(value = "MaxCapacity")
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


}
