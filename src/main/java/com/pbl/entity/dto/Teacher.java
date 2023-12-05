package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AAAHang
 * @since 2023-12-05
 */
@TableName("user_teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，唯一标识用户
     */
    @TableId(value = "userID", type = IdType.AUTO)
    private Integer userID;

    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 密码，用于登录验证
     */
    @TableField("passWord")
    private String passWord;

    /**
     * 工号
     */
    @TableField("teacherId")
    private String teacherId;

    /**
     * 联系电话号码
     */
    private String phone;

    /**
     * 电子邮件地址
     */
    private String email;

    /**
     * 微信账号
     */
    @TableField("weChat")
    private String weChat;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 用户简介
     */
    private String bio;

    /**
     * 所属学院
     */
    private String college;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "UserTeacher{" +
        "userID = " + userID +
        ", userName = " + userName +
        ", passWord = " + passWord +
        ", teacherId = " + teacherId +
        ", phone = " + phone +
        ", email = " + email +
        ", weChat = " + weChat +
        ", qq = " + qq +
        ", bio = " + bio +
        ", college = " + college +
        "}";
    }
}
