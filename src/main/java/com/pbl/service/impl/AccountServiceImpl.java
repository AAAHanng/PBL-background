package com.pbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.Account;
import com.pbl.entity.vo.response.AccountVO;
import com.pbl.mapper.AccountMapper;
import com.pbl.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    AccountMapper mapper;

    /**
     * 从数据库中通过用户名或邮箱查找用户详细信息
     * @param // username 用户名
     * @return 用户详细信息
     * @throws UsernameNotFoundException 如果用户未找到则抛出此异常
     */
    @Override
    public UserDetails loadUserByUsername(String studentID) throws UsernameNotFoundException {
        Account account = this.findAccountByNameOrEmail(studentID);
        if(account == null)
            throw new UsernameNotFoundException("用户名或密码错误");
        return User
                .withUsername(studentID)
                .password(account.getPassword())
                .build();
    }

    @Override
    public String findAccountByStudent(String text) {
        Account account = findAccountByNameOrEmail(text);
        if (account.getIdentification()==1){
            return "student";
        }else if (account.getIdentification()==2) {
            return "admin";
        }else{
            return "teacher";
        }
    }

    /**
     * 通过Name查找用户
     * @param text 用户名
     * @return 账户实体
     */
    public Account findAccountByNameOrEmail(String text){
        return this.query()
                .eq("studentid", text).or()
                .one();
    }

    /**
     * 通过StudentID查找用户
     * @param text 用户名
     * @return 账户实体
     */
    @Override
    public AccountVO findAccountByStudentID(String text) {
        Account account = this.query().eq("StudentID", text).one();
        return (account == null) ? null : account.asViewObject(AccountVO.class);
    }

    /**
     * 通过查找用户
     * @param StudentID 用户名
     * @return
     */
    @Override
    public String updateContactInfo(String StudentID, String phone, String email, String wechat, String qq) {
        try {

            if (findAccountByStudentID(StudentID) == null) {
                return null;
            } else {
                UpdateWrapper<Account> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("studentid", StudentID)
                        .set("phone", phone)
                        .set("email", email)
                        .set("wechat", wechat)
                        .set("qq", qq);
                mapper.update(null, updateWrapper);
                return "修改成功";
            }
        } catch (Exception e) {
            e.printStackTrace(); // 在实际应用中，根据需求进行日志记录或其他处理
            return "修改失败";
        }
    }

    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return String状态
     */

    @Override
    public String createUser(Account account) {
        try {
            this.save(account);
            return "用户创建成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "用户创建失败，可能出现错误：";
        }
    }

    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return String状态
     */
    @Override
    public Account getUserById(String studentid) {
        try {
            // 使用 LambdaQueryWrapper 来构建查询条件
            LambdaQueryWrapper<Account> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Account::getStudentid, studentid);
            return this.getOne(wrapper);
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return null;
        }
    }

    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return String状态
     */
    @Override
    public String updateUser(Account account) {
        try {
            UpdateWrapper<Account> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("studentID", account.getStudentid());

            this.update(account, updateWrapper);

            return "课程更新成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程更新失败，可能出现错误：";
        }
    }


    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return String状态
     */
    @Override
    public String deleteUser(String studentID) {
        try {
            // 使用 LambdaQueryWrapper 来构建查询条件
            LambdaQueryWrapper<Account> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Account::getStudentid, studentID);

            // 调用 MyBatis Plus 的 remove 方法来执行删除操作
            this.remove(wrapper);
            return "课程删除成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程删除失败，可能出现错误：" ;
        }
    }

}







