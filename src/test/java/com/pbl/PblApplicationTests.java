package com.pbl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pbl.entity.dto.Account;
import com.pbl.mapper.AccountMapper;
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
    CourseService service1;

    @Test
    void contextLoads() {
        service.findAccountByNameOrEmail("2021402030601");
    }

    @Test
    void encoded(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

    @Test
    void datasource(){
        System.out.println(service.updateContactInfo("2021402030611","13611111111",null,null,null));
    }

    @Test
    void datasourceCourse(){
        System.out.println(service1.getCourses("王丽"));
    }
}
