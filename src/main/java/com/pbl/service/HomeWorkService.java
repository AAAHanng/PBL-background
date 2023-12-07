package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.HomeWork;
import com.pbl.entity.dto.HomeWorkRegistration;

import java.util.List;

public interface HomeWorkService extends IService<HomeWorkRegistration> {


    String putHomeWork(String teacherId, String courseId, String classId,String homeWorkName,String description);

    List<HomeWork> getHomeWorkByTeacherIdAndClassID(String teacherId, String courseId);

    HomeWork getHomeWorkByTeacherIdAndClassIDAndCourseId(String homeWorkId);

    String updateHomWorkGrade(String homeWorkId, String grade);
}
