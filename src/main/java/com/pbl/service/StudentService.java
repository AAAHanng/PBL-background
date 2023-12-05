package com.pbl.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Student;
import com.pbl.entity.vo.response.AccountVO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface StudentService extends IService<Student>, UserDetailsService {
    Student findAccountByNameOrEmail(String text);


    String updateInfo(String studentID, String phone, String email, String wechat, String qq, String bio);

    Student getContactByStudentID(String studentID);
}
