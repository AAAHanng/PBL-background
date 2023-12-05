package com.pbl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.pbl.entity.dto.Course;
import com.pbl.entity.dto.Enrollment;
import com.pbl.mapper.CourseMapper;
import com.pbl.mapper.EnrollmentMapper;
import com.pbl.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    EnrollmentMapper enrollmentMapper;

    @Resource
    CourseMapper courseMapper;

//    @Resource
//    AmqpTemplate rabbitTemplate;


    /**
     * 查询所有课程
     * @return 课程对象
     */
    @Override
    public List FindAllCourse() {
        List<Course> list = courseMapper.selectList(null);
        if (list == null) return Collections.singletonList("查无数据");
        return list;
    }

    /**
     * 找到所有课程by 学号
     * @param // StudentID
     * @return 课程对象 列表
     */
    @Override
    public List<Course> FindALCourse(String studentID) {
        // 查询符合条件的 Enrollment 记录
        QueryWrapper<Enrollment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("StudentID", studentID);
        List<Enrollment> enrollments = enrollmentMapper.selectList(queryWrapper);

        if (enrollments.isEmpty()) {
            // 如果没有符合条件的 Enrollment 记录，可以根据实际情况处理，例如返回空列表或抛出异常
            return null;
        }

        // 提取 CourseID 列表
        List<String> courseIds = enrollments.stream().map(Enrollment::getCourseID).collect(Collectors.toList());

        // 查询符合条件的 Course 记录
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.in("CourseID", courseIds);
        return courseMapper.selectList(courseQueryWrapper);
    }

    /**
     * 学生通过学号课程请求选课
     *
     * @param // StudentID
     * @return 课程对象
     */
    @Override
    public String submitCourseRequest(String courseID, String studentID) {
        if (!enrollmentExists(studentID, courseID)) {
            Course Grade = this.query()
                    .eq("courseid", courseID)
                    .one();
            LocalDateTime currentDateTime = LocalDateTime.now();

            Enrollment enrollment = new Enrollment(
                    null, studentID, courseID, currentDateTime, Grade.getCredits(), "等待"
            );

            enrollmentMapper.insert(enrollment);
            return "插入成功";
        } else {
            return "已经选了";
        }

//        这段是启用rabbitmq 用作与流量销峰
//        Map<String, Object> data = Map.of("courseID", courseID, "studentID", studentID);
//        rabbitTemplate.convertAndSend(Const.COURSE_REQUEST, data);
    }



    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return 课程对象列表
     */
    @Override
    public List<Map<String, Object>> TeacherClassList(String courseID,String type) {List<Map<String, Object>> enrollmentList = enrollmentMapper.getEnrollmentsByCourseId("1");
        // 根据Status字段分组
        Map<String, List<Map<String, Object>>> groupedByStatus = enrollmentList.stream()
                .collect(Collectors.groupingBy(result -> result.get("Status").toString()));

        switch (type) {
            case "已选课":
                return groupedByStatus.getOrDefault("已选课", Collections.emptyList());
            case "等待":
                return groupedByStatus.getOrDefault("等待", Collections.emptyList());
            default:
                return enrollmentList;
        }

    }

    @Override
    public String TeacherChange(String studentID, String courseID, String type) {
        if(enrollmentExists(studentID,courseID)){
                updateStatus(studentID,courseID,type);
        }else{
            return "没有此用户";
        }
        return null;
    }


    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return String状态
     */

    @Override
    public String createCourse(Course course) {
        try {
            Course course1 = new Course();
            BeanUtils.copyProperties(course,course1);
            course1.setTeacherID("2021402030615");
            this.save(course1);
            course.setTeacherID("2021402030616");
            this.save(course);
            return "课程创建成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程创建失败，可能出现错误：";
        }
    }

    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return String状态
     */
    @Override
    public Course getCourseById(String courseId) {
        try {
            Course course = this.getById(courseId);
            return course;
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return null;
        }
    }

    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return String状态
     */
    @Override
    public String updateCourse(Course course) {
        try {
            this.updateById(course);
            return "课程更新成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程更新失败，可能出现错误：";
        }
    }


    /**
     * 根据课程号
     *
     * @param // CourseID
     * @return String状态
     */
    @Override
    public String deleteCourse(String courseId) {
        try {
            this.removeById(courseId);
            return "课程删除成功";
        } catch (Exception e) {
            e.printStackTrace(); // 记录日志
            return "课程删除失败，可能出现错误：" ;
        }
    }

    @Override
    public  List<Map<String, Object>> getCoursesForStudents() {
        return courseMapper.getCoursesForStudents();
    }

    @Override
    public List<Map<String, Object>> getCourses(String teacher) {
        return courseMapper.getCourseByName(teacher);
    }

    @Override
    public List<Map<String, Object>> getStudentInfo(String teacher) {
        return courseMapper.getStudentInfo(teacher);
    }

    @Override
    public String updateCourseDescription(String courseId,String description) {
        int affectedRows = courseMapper.updateCourseDescription(courseId ,description);

        return (affectedRows > 0) ? "修改成功" : "修改失败";
    }

    @Override
    public List<Map<String, Object>> getRequestList(String studentID) {
        return courseMapper.getUserCoursesWithStudentId(studentID);
    }


    @Override
    public List<Map<String, Object>> getStudentCourseInfoByStudentID(String studentID , int type) {
        List<Map<String, Object>> AllList = courseMapper.getStudentCourseInfoByStudentID(studentID);
        if (type == 1) {
            // 过滤掉 status 为等待的记录
            return AllList.stream()
                    .filter(enrollment -> !"等待".equals(enrollment.get("Status")))
                    .collect(Collectors.toList());
        } else if (type == 2) {
            // 过滤掉 status 为已选课的记录
            return AllList.stream()
                    .filter(enrollment -> !"已选课".equals(enrollment.get("Status")))
                    .collect(Collectors.toList());
        } else {
            // type 为 3，不进行过滤，返回原始列表
            return AllList;
        }
    }

    @Override
    public List<Course> getAllCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        return courseMapper.selectList(queryWrapper);
    }


    /**
     * 查看数据是否存在
     * @param // Studentid courseid
     * @return // boolean
     * */
    private boolean enrollmentExists(String studentID,String courseID) {
        // Query the database to check if the enrollment already exists
        QueryWrapper<Enrollment> selectWrapper = new QueryWrapper<>();
        selectWrapper.eq("studentID", studentID)
                .eq("courseid", courseID);
        Enrollment result = enrollmentMapper.selectOne(selectWrapper);
        return result != null;
    }

    /**
     * 通过学号 课程号删除选课信息
     *
     * @param // StudentID
     * @return 课程对象
     */
    private String deleteEnrollment(String studentId, String courseId) {
        try {
            QueryWrapper<Enrollment> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("StudentID", studentId).eq("CourseID", courseId);
            int deletedRows = enrollmentMapper.delete(queryWrapper);

            if (deletedRows > 0) {
                return "删除成功";
            } else {
                return "没有匹配的数据";
            }
        } catch (Exception e) {
            System.err.println("错误删除: " + e.getMessage());
            e.printStackTrace(); // 打印异常堆栈信息
        }
        return null;
    }

    /**
     * 通过学号课程号 更新 选课status 状态
     *
     * @param // StudentID
     * @return 课程对象
     */
    private String updateStatus(String studentId, String courseId,String type){
        try {
            // 创建更新条件
            UpdateWrapper<Enrollment> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("StudentID", studentId)
                    .eq("courseID", courseId);
            // 执行更新操
            int rowsAffected = enrollmentMapper.update(null, updateWrapper.set("status",type));

            if (rowsAffected > 0) {
                return "更新成功";
            } else {
                return "更新失败，未找到符合条件的记录";
            }
        } catch (Exception e) {
            System.err.println("错误删除: " + e.getMessage());
            e.printStackTrace(); // 打印异常堆栈信息
        }
        return null;
    }
}

