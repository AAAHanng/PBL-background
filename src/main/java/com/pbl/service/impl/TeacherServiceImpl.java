package com.pbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.Student;
import com.pbl.entity.dto.Teacher;
import com.pbl.mapper.TeacherMapper;
import com.pbl.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper , Teacher> implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;

    @Override
    public String updateInfo(String teacherId, String phone, String email, String wechat, String qq, String bio) {
        try {
            UpdateWrapper<Teacher> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("teacherId",teacherId)
                    .set("phone", phone)
                    .set("email", email)
                    .set("wechat", wechat)
                    .set("qq", qq)
                    .set("bio",bio);
            teacherMapper.update(null, updateWrapper);
            return "修改成功";
        } catch (Exception e) {
            return "修改失败";
        }
    }
    @Override
    public Teacher getContactByStudentID(String teacherId) {
        return this.query().eq("teacherId", teacherId).one();
    }

}
