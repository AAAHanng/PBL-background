package com.pbl;

import com.pbl.entity.dto.Account;
import com.pbl.mapper.AccountMapper;
import com.pbl.service.AccountService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PblApplicationTests {

    @Resource
    AccountService service;

    @Test
    void contextLoads() {
        service.findAccountByNameOrEmail("20180001");
    }

}
