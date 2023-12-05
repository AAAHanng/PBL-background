package com.pbl;

import com.pbl.service.AccountService;
import com.pbl.service.CourseService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class PblApplicationTests {

    @Resource
    AccountService service;

    @Resource
    CourseService courseService;

    @Test
    void contextLoads() {
        courseService.getRequestList("2021402030615");
    }

    @Test
    void encoded(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }



}
