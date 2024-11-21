package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        String name = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + name.substring(file.getOriginalFilename().lastIndexOf("."));

        String url = AliOssUtil.UploadFile(fileName, file.getInputStream());

        return Result.success(url);
    }
}
