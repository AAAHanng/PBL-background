package com.pbl.controller;

import com.pbl.entity.RestBean;
import com.pbl.entity.dto.UpdateFile;
import com.pbl.service.UploadService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping("/api/file")
public class UploadController {

    @Resource
    private UploadService uploadService;

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public RestBean<String> uploadFile(MultipartFile file, UpdateFile params) {
        return (uploadService.uploadFile(file, params))
                ?RestBean.success("上传成功"):RestBean.failure(400,"上传失败");
    }
}









