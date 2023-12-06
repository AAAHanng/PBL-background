package com.pbl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pbl.entity.dto.UpdateFile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService extends IService<UpdateFile> {
    boolean uploadFile(MultipartFile file , UpdateFile params);

    ResponseEntity<Object> downloadFile(String fileName);
}
