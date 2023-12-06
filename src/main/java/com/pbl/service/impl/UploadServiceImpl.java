package com.pbl.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pbl.entity.dto.UpdateFile;
import com.pbl.mapper.FileMapper;
import com.pbl.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UploadServiceImpl extends ServiceImpl<FileMapper, UpdateFile> implements UploadService {

    @Value("${spring.servlet.sava}")

    private String savaFile;

    @Override
    public boolean uploadFile(MultipartFile file, UpdateFile params) {
        // 截取文件名 的后缀 防止出现文件名的重复 覆盖
        String realfilename = file.getOriginalFilename();
        String imgSuffix = null;
        if (realfilename != null) {
            imgSuffix = realfilename.substring(realfilename.lastIndexOf("."));
        }
        //  将其生成唯一的文件名
        String uuId = String.valueOf(UUID.randomUUID());
        String saveFileName = uuId+imgSuffix;

        //  日期目录
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String datePath  = dateFormat.format(new Date());


        String servrepath= savaFile; // 上传的目录


        // 指定文件上传的目录   生成一个最终的目录
        File targetFile  = new File(servrepath);
        if(!targetFile.exists()) {
            boolean res = targetFile.mkdir();
            System.out.println("文件目录创建:"+res);
        }

        // 指定文件上传以后服务器完整的文件名
        File targetFilname = new File(targetFile,saveFileName);
        //   文件上传
        try {
            file.transferTo(targetFilname);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        //保存文件信息
        UpdateFile uploadEntity = new UpdateFile()
                .setUploadTime(datePath)
                .setType(imgSuffix)
                .setCourseId(params.getCourseId())
                .setUserId(params.getCourseId())
                .setFileName(params.getFileName())
                .setSaveFileName(saveFileName)
                .setUuId(uuId)
                .setTotalSize(String.valueOf(file.getSize()+"bytes"));
        save(uploadEntity);
        return true;
    }
}
