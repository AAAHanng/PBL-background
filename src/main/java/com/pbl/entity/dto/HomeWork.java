package com.pbl.entity.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("HomeWork")
@Accessors
@Builder
public class HomeWork {

    private static final long serialVersionUID = 1L;

    /**
     * 选课ID，唯一标识每次选课
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer Id;

    /**
     * 学生ID，关联到 user_student 表
     */
    @TableField("homeWorkId")
    private String homeWorkId;

    /**
     * 学生ID，关联到 user_student 表
     */
    @TableField("HomeWorkName")
    private String HomeWorkName;

    @TableField("HomeWorkTime")
    private String HomeWorkTime;

    @TableField("description")
    private String description;

    @TableField("teacher")
    private String teacher;

}
