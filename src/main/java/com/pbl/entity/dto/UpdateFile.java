package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
@TableName("File")
@Data
public class UpdateFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableField("uuId")
    private String uuId;

    /**
     * 文件ID，唯一标示
     */
    @TableField("courseId")
    private String courseId;

    /**
     * 文件本身的名字
     */
    @TableField("fileName")
    private String fileName;

    /**
     * 文件的总大小
     */
    @TableField("totalSize")
    private String totalSize;

    /**
     * 用户上传的Id，用来区分是哪个用户上传
     */
    @TableField("userId")
    private String userId;

    /**
     * 上传后文件保存的名字，uuid+userId+type
     */
    @TableField("saveFileName")
    private String saveFileName;

    /**
     * 上传文件的类型
     */
    private String type;

    /**
     * 上传时间
     */
    @TableField("uploadTime")
    private String uploadTime;

}
