package com.ruoyi.project.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传工具类
 */
public class UploadUtil {

    /**
     *
     * @param file
     * @param pathFile 路径
     * @return
     * @throws IOException
     */
    public static String upload(MultipartFile file , String pathFile) throws IOException {
        //得到正式的上传路径
        String name = file.getOriginalFilename();
        //得到上传后缀名
        String suffixName = name.substring(name.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString()+suffixName;
        File tempFile = new File(pathFile,uuid);
        if(!tempFile.getParentFile().exists()){
            tempFile.getParentFile().mkdir();
        }
        if(tempFile.exists()){
            tempFile.delete();
        }
        tempFile.createNewFile();
        file.transferTo(tempFile);
        return tempFile.getName();
    }

}
