package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Admin;
import com.pbl.entity.dto.Teacher;

public interface AdminService extends IService<Admin> {

    Admin getContactByTeacherID(String teacherId);
}
