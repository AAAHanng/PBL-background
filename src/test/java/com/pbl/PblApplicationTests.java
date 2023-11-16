package com.pbl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pbl.entity.dto.Account;
import com.pbl.mapper.AccountMapper;
import com.pbl.service.AccountService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class PblApplicationTests {

    @Resource
    AccountService service;

    @Test
    void contextLoads() {
        service.findAccountByNameOrEmail("JohnDoe");
    }

    @Test
    void encoded(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

    @Test
    void datasource(){
        System.out.println(service.updateContactInfo("2021402030611","13611111111",null,null,null));
    }

}
