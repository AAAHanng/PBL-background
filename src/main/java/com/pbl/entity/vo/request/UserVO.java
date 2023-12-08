package com.pbl.entity.vo.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserVO {
    String username;
    String password;
    String identity;
}