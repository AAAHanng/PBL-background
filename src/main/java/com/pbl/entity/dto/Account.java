package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pbl.entity.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author AAAhang
 * @since 2023-10-26
 */
@Data
@TableName("User")
@AllArgsConstructor
public class Account implements Serializable, BaseData {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，唯一标识用户
     */
    @TableId(value = "UserID", type = IdType.AUTO)
    private Integer userID;

    /**
     * 用户名，用于登录
     */
    private String username;

    /**
     * 密码，用于登录验证
     */
    private String password;

    /**
     * 学号或账号，唯一标识
     */
    @TableField(value="studentid")
    private String studentid;

    /**
     * 身份标示，1为学生，0为教职工
     */
    private Integer identification;

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
    private String wechat;

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


}
