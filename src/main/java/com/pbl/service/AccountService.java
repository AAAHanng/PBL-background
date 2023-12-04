package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Account;
import com.pbl.entity.vo.response.AccountVO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IService<Account>, UserDetailsService {

    String findAccountByStudent(String text);
    Account findAccountByNameOrEmail(String text);

    AccountVO findAccountByStudentID(String text);

    String updateContactInfo(String StudentID,String phone,String email,String wechat,String qq, String bio);

    String createUser(Account account);

    Account getUserById(String studentID);

    String updateUser(Account account);

    String deleteUser(String teacher);


}
