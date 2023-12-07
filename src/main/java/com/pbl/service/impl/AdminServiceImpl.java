package com.pbl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.Admin;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.Student;
import com.pbl.entity.dto.Teacher;
import com.pbl.mapper.AdminMapper;
import com.pbl.mapper.CourseMapper;
import com.pbl.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    CourseMapper courseMapper;


    public Admin findAccountByNameOrEmail(String text){
        return this.query()
                .eq("studentId", text).or()
                .one();
    }
    @Override
    public Admin getContactByTeacherID(String studentId) {
        return this.query().eq("studentId", studentId).one();
    }

    @Override
    public List<Map<String, Object>> getCourse() {
        return courseMapper.getAllCourse();
    }


}
