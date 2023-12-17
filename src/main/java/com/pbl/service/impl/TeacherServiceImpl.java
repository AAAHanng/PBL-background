package com.pbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.ClassRegistration;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.CourseRegistration;
import com.pbl.entity.dto.Teacher;
import com.pbl.mapper.CourseRegistrationMapper;
import com.pbl.mapper.CourseTeacherMapper;
import com.pbl.mapper.TeacherMapper;
import com.pbl.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper , Teacher> implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;

    @Resource
    CourseTeacherMapper courseTeacherMapper;

    @Resource
    CourseRegistrationMapper courseRegistrationMapper;



    public Teacher findTeacherByNameOrEmail(String text){
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacherId",text);
        return teacherMapper.selectOne(queryWrapper);
    }

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

    @Override
    public List<Map<String,Object>> getTeacherClassList(String teacherId, int type) {
        List<Map<String, Object>> teacherClassList = teacherMapper.getTeacherClassList(teacherId);
        return teacherClassList.stream()
                .filter(entity -> {
                    String status = (String) entity.get("status");
                    switch (type) {
                        case 0:
                            // 返回全部
                            return true;
                        case 1:
                            // 保留等待
                            return "等待".equals(status);
                        case 2:
                            // 保留已选课
                            return "已选课".equals(status);
                        default:
                            // 默认返回全部
                            return true;
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> getTeacherHasClassList(String teacherId) {
       return courseTeacherMapper.getTeacherHasClassList(teacherId);}

    @Override
    public List<Map<String, Object>> getStudentListByTeacherId(String teacherId) {
        return null;
    }

    @Override
    public String updateClassStatus(String teacherId, String courseId, String type,String studentId) {
        try {
            // 创建更新条件
            UpdateWrapper<CourseRegistration> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("teacherId", teacherId)
                    .eq("courseId", courseId)
                    .eq("studentId",studentId);
            // 执行更新操
            int rowsAffected = courseRegistrationMapper.update(null, updateWrapper.set("status",type));

            if (rowsAffected > 0) {
                return "更新成功";
            } else {
                return "更新失败，未找到符合条件的记录";
            }
        } catch (Exception e) {
            System.err.println("错误删除: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String addTeacher(Teacher teacher) {
        try {
            this.save(teacher);
            return "学生创建成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程创建失败，可能出现错误：";
        }
    }

    @Override
    public String deleteTeacher(String teacherId) {
        try {
            this.removeById(teacherId);
            return "课程删除成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程删除失败，可能出现错误：" ;
        }
    }

    @Override
    public String updateStudent(Teacher student) {
        try {
            this.updateById(student);
            return "课程更新成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程更新失败，可能出现错误：";
        }
    }

    @Override
    public List<Teacher> getTeacher() {
        return teacherMapper.selectList(Wrappers.emptyWrapper());
    }

    @Override
    public List<Map<String,Object>>  getCourseAndClassesAndHomeWorkName(String studentId) {
        return courseRegistrationMapper.getCourseAndHomeWorkName(studentId);
    }
}
