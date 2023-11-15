package com.pbl.entity.vo.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AccountVO {

    private Integer userID;

    /**
     * 用户名，用于登录
     */
    private String username;

    /**
     * 学号或账号，唯一标识
     */
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
