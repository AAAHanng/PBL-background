package com.pbl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.Admin;
import com.pbl.entity.dto.Teacher;
import com.pbl.mapper.AdminMapper;
import com.pbl.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Override
    public Admin getContactByTeacherID(String studentId) {
        return this.query().eq("studentId", studentId).one();
    }
}
