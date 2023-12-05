package com.pbl.entity.dto;

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
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String uuId;

    /**
     * 文件ID，唯一标示
     */
    private String courseId;

    /**
     * 文件本身的名字
     */
    private String fileName;

    /**
     * 文件的总大小
     */
    private String totalSize;

    /**
     * 用户上传的Id，用来区分是哪个用户上传
     */
    private String userId;

    /**
     * 上传后文件保存的名字，uuid+userId+type
     */
    private String saveFileName;

    /**
     * 上传文件的类型
     */
    private String type;

    /**
     * 上传时间
     */
    private LocalDateTime uploadTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "File{" +
        "uuId = " + uuId +
        ", courseId = " + courseId +
        ", fileName = " + fileName +
        ", totalSize = " + totalSize +
        ", userId = " + userId +
        ", saveFileName = " + saveFileName +
        ", type = " + type +
        ", uploadTime = " + uploadTime +
        "}";
    }
}
