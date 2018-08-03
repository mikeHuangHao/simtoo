package com.ruoyi.project.common;

import com.ruoyi.project.util.UploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片/文件上传
 */
@Controller
public class UploadController {

    @Value("${upload.uploadPath}")
    private String uploadPath;

    /**
     * 文件上传
     * @param request
     * @param response
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(HttpServletRequest request , HttpServletResponse response , MultipartFile file){
        Map<String,Object> map = new HashMap<>();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
        try {
            String resultFileName = UploadUtil.upload(file,uploadPath);
            map.put("code", 0);
            map.put("image", basePath+resultFileName);
        }catch (Exception e){
            map.put("code", 01);
            map.put("image", "");
        }
        return map;
    }
}
