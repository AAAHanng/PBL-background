package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程ID，唯一标识课程
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程ID，唯一标示
     */
    private String courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程地点
     */
    private String location;

    /**
     * 课程时间
     */
    private LocalDateTime courseTime;

    /**
     * 课程人数上限
     */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(LocalDateTime courseTime) {
        this.courseTime = courseTime;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

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
