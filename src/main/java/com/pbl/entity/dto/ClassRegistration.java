package com.pbl.entity.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ClassRegistration")
public class ClassRegistration {
    private int id;
    private String classId;
    private String studentId;
}
