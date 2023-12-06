package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

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
@TableName("FileRegistration")
@Accessors(chain = true)
@Data
public class FileRegistration implements Serializable {

    @Serial
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

}
