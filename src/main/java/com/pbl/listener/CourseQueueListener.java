package com.pbl.listener;

import com.pbl.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
//
//@Component
//@RabbitListener(queues = "course")
public class CourseQueueListener {

    @Resource
    CourseService courseService;

    @RabbitHandler
    public void processCourseMessage(Map<String,Object> data) {

        String studentID = data.get("studentID").toString();
        String courseID = data.get("courseId").toString();
//        System.out.println(studentID);
//        System.out.println(courseID);
//        // 老师处理选课信息
//        String approval = data.get("approval").toString(); // 根据实际业务逻辑决定是否同意选课
//
//
//        // 更新数据库状态或删除信息
//        if (Objects.equals(approval, "TRUE")) {
//            // 更新数据库状态为同意
//            courseService.updateStatus(studentID,courseID);
//        } else {
//            // 不同意则删除数据库中的信息
//            courseService.deleteEnrollment(studentID,courseID);
//        }
    }

}
