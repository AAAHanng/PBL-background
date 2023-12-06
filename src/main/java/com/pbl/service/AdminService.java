package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Admin;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.Teacher;

import java.util.List;
import java.util.Map;

public interface AdminService extends IService<Admin> {

    Admin getContactByTeacherID(String teacherId);

    List<Map<String,Object>> getCourse();


}
