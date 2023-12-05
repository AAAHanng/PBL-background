package com.pbl;


import com.pbl.service.StudentService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@SpringBootTest
class PblApplicationTests {

    @Resource
    StudentService studentService;

    @Resource
    DataSource source;

    @Test
    void encoded(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }


    @Test
    void student(){
        studentService.updateInfo("2021402030602","1","1","1","1","1");
    }


}
