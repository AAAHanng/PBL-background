package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Student;
import com.pbl.entity.dto.Teacher;

public interface TeacherService extends IService<Teacher>{


    String updateInfo(String teacherId, String phone, String email, String wechat, String qq, String bio);

    Teacher getContactByStudentID(String teacherId);
}