package com.pbl.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/test")
@Tag(name = "登录校验相关", description = "包括用户登录、注册、验证码请求等操作。")
public class TestController {

    @GetMapping("/hello")
    public String test(){
        return "hello world";
    }
}
