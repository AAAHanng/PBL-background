package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AAAHang
 * @since 2023-12-05
 */
@Builder
@Accessors(chain = true)
@Data
@TableName("HomeWorkRegistration")
public class HomeWorkRegistration implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 选课ID，唯一标识每次选课
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer Id;

    /**
     * 学生ID，关联到 user_student 表
     */
    @TableField("studentId")
    private String studentId;

    /**
     * 老师ID，关联到 user_teacher 表
     */
    @TableField("teacherId")
    private String teacherId;

    /**
     * 课程ID，关联到 Course 表
     */
    @TableField("homeWorkId")
    private String homeWorkId;

    /**
     * 状态
     */
    @TableField("fileId")
    private String fileId;

    @TableField("homeWorkGrade")
    private String homeWorkGrade;

    @TableField("Status")
    private String Status;


    @TableField("classId")
    private String classId;

    @TableField("courseId")
    private String courseId;


}
