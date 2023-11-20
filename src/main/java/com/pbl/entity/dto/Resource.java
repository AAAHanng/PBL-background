package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("Resource")
@Data
@AllArgsConstructor
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID，唯一标识资源
     */
    @TableId(value = "ResourceID", type = IdType.AUTO)
    private Integer resourceID;

    /**
     * 文件名字
     */
    private String fileName;

    /**
     * 上传人
     */
    private String uploader;

    /**
     * 上传时间
     */
    private LocalDateTime uploadTime;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小 (字节数)
     */
    private Integer fileSize;

}
