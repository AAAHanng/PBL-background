package com.pbl;


import com.pbl.service.StudentService;
import com.pbl.service.TeacherService;
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

    @Resource
    TeacherService teacherService;

    @Test
    void encoded(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }


    @Test
    void student(){
        studentService.putCourseRequest("2021402030601","2021402030611","1");
    }

    @Test
    void studentdemo(){
        teacherService.findTeacherByNameOrEmail("2021402030611");
    }


}
