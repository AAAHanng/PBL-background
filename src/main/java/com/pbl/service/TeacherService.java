package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService extends IService<Teacher>{


    String updateInfo(String teacherId, String phone, String email, String wechat, String qq, String bio);

    Teacher getContactByStudentID(String teacherId);

    List<Map<String,Object>> getTeacherClassList(String teacherId, int type);

    List<Map<String, Object>> getTeacherHasClassList(String teacherId);

    List<Map<String, Object>> getStudentListByTeacherId(String teacherId);

    String updateClassStatus(String teacherId, String courseId, String type,String studentId);
}