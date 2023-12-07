package com.pbl.entity.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 登录验证成功的用户信息响应
 */
@Data
@Accessors(chain = true)
public class AuthorizeVO {
    String username;
    String token;
    Date expire;
    String identity;
}
