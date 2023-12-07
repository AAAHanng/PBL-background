package com.pbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.HomeWork;
import com.pbl.entity.dto.HomeWorkRegistration;
import com.pbl.mapper.HomeWorkMapper;
import com.pbl.mapper.HomeWorkRegistrationMapper;
import com.pbl.service.HomeWorkService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HomeWorkServiceImpl extends ServiceImpl<HomeWorkRegistrationMapper, HomeWorkRegistration> implements HomeWorkService {

    @Resource
    HomeWorkMapper homeWorkMapper;

    @Resource
    HomeWorkRegistrationMapper homeWorkRegistrationMapper;
    @Override
    public String putHomeWork(String teacherId, String courseId, String classId,String homeWorkName,String description) {
        String uuId = String.valueOf(UUID.randomUUID());
        HomeWorkRegistration homeWorkRegistration = HomeWorkRegistration.builder()
                .teacherId(teacherId)
                .courseId(courseId)
                .classId(classId)
                .homeWorkId(uuId)
                .build();
        save(homeWorkRegistration);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String datePath  = dateFormat.format(new Date());
        HomeWork homeWork = HomeWork.builder()
                .homeWorkId(uuId)
                .HomeWorkName(homeWorkName)
                .description(description)
                .HomeWorkTime(datePath)
                .build();
        homeWorkMapper.insert(homeWork);
        return "成功";
    }

    @Override
    public List<HomeWork> getHomeWorkByTeacherIdAndClassID(String teacherId, String courseId) {
        QueryWrapper<HomeWorkRegistration> queryWrapper = Wrappers.query();
        queryWrapper.eq("teacherID", teacherId).eq("courseId", courseId);

        List<HomeWorkRegistration> data = homeWorkRegistrationMapper.selectList(queryWrapper);

        return (data != null && !data.isEmpty()) ?
                homeWorkMapper.selectList(Wrappers.<HomeWork>query().in("homeWorkId", data.stream()
                        .map(HomeWorkRegistration::getHomeWorkId)
                        .collect(Collectors.toList())))
                : null;
    }

    @Override
    public HomeWork getHomeWorkByTeacherIdAndClassIDAndCourseId(String homeWorkId) {
        return homeWorkMapper.selectOne(Wrappers.<HomeWork>query().eq("homeWorkId", homeWorkId));
    }

    @Override
    public String updateHomWorkGrade(String homeWorkId, String grade) {
        // 查询特定作业记录
        QueryWrapper<HomeWorkRegistration> queryWrapper = Wrappers.query();
        queryWrapper.eq("homeWorkId", homeWorkId);
        HomeWorkRegistration homework = homeWorkRegistrationMapper.selectOne(queryWrapper);
        // 如果找到了作业记录，则更新分数
        if (homework != null) {
            homework.setHomeWorkGrade(grade);
            int updatedRows = homeWorkRegistrationMapper.updateById(homework);
            return (updatedRows > 0) ? "修改成功" : "修改失败";
        } else {
            // 如果未找到作业记录
            return "未找到作业记录：" + homeWorkId;
        }

    }

}
