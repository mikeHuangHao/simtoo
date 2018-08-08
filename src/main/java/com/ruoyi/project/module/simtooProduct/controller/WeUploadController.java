package com.ruoyi.project.module.simtooProduct.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.util.ResponseUtil;
import com.ruoyi.project.util.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class WeUploadController {
	private static Logger logger = LoggerFactory.getLogger(WeUploadController.class);

	@Value("${upload.uploadPath}")
	private String uploadPath; // 上传文件的目录  
	
	/**
	 * ueEditor（百度）富文本框
	 * @param
	 * @param response
	 * @return
	 */
	 @RequestMapping("/weUpload")
	 @ResponseBody
	 public void upLoadEditorImg(@RequestParam("upfile") List<MultipartFile> list,HttpServletResponse response) throws IOException {
		 	JSONObject obj = new JSONObject();
	        List<String> resultImg = new ArrayList<>();
	        String image = "";
	        String config = "";
	        try {
	            for(MultipartFile img : list) {
	           //获取原始文件名，比如你上传的是　图片．jpg,则fileName＝图片．jpg
	                String fileName = img.getOriginalFilename();
	                if(fileName == "") {
	                    continue;
	                }
	                image = UploadUtil.upload(img, uploadPath);
	    	        config = "{\"state\": \"SUCCESS\"," +
	    	                "\"url\": \"/"+image+"\"," +
	    	                "\"title\": \"/"+image+"\"," +
	    	                "\"src\": \"/"+image+"\"," +
	    	                "\"original\": \"/"+image+"\"}";

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        ResponseUtil.writeJson(response, config);
	    }

	@RequestMapping("/weUploadVideo")
	@ResponseBody
	public void upLoadEditorVideo(@RequestParam("upfile") MultipartFile file,HttpServletResponse response) throws IOException {
		System.out.println("111");
	}
	
	 @RequestMapping(value="/config")
	 @ResponseBody
	public String config(HttpServletRequest request, HttpServletResponse response) {
		String result = "{\n" +
				 "    \"imageActionName\": \"uploadimage\",\n" +
				 "    \"imageFieldName\": \"upfile\",\n" +
				 "    \"imageMaxSize\": 2048000000,\n" +
				 "    \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\n" +
				 "    \"imageCompressEnable\": true,\n" +
				 "    \"imageCompressBorder\": 1600,\n" +
				 "    \"imageInsertAlign\": \"none\",\n" +
				 "    \"imageUrlPrefix\": \"\",\n" +
				 "    \"imagePathFormat\": \"/js/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
				 "\n" +
				 "    \"scrawlActionName\": \"uploadscrawl\",\n" +
				 "    \"scrawlFieldName\": \"upfile\",\n" +
				 "    \"scrawlPathFormat\": \"/js/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
				 "    \"scrawlMaxSize\": 2048000000,\n" +
				 "    \"scrawlUrlPrefix\": \"\",\n" +
				 "    \"scrawlInsertAlign\": \"none\",\n" +
				 "\n" +
				 "    \"snapscreenActionName\": \"uploadimage\",\n" +
				 "    \"snapscreenPathFormat\": \"/js/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
				 "    \"snapscreenUrlPrefix\": \"\",\n" +
				 "    \"snapscreenInsertAlign\": \"none\",\n" +
				 "\n" +
				 "    \"catcherLocalDomain\": [\"127.0.0.1\", \"localhost\", \"img.baidu.com\"],\n" +
				 "    \"catcherActionName\": \"catchimage\",\n" +
				 "    \"catcherFieldName\": \"source\",\n" +
				 "    \"catcherPathFormat\": \"/js/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
				 "    \"catcherUrlPrefix\": \"\",\n" +
				 "    \"catcherMaxSize\": 204800000,\n" +
				 "    \"catcherAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\n" +
				 "\n" +
				 "    \"videoActionName\": \"uploadvideo\",\n" +
				 "    \"videoFieldName\": \"upfile\",\n" +
				 "    \"videoPathFormat\": \"/js/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
				 "    \"videoUrlPrefix\": \"\",\n" +
				 "    \"videoMaxSize\": 10240000000,\n" +
				 "    \"videoAllowFiles\": [\n" +
				 "        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
				 "        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\"],\n" +
				 "\n" +
				 "    \"fileActionName\": \"uploadfile\",\n" +
				 "    \"fileFieldName\": \"upfile\",\n" +
				 "    \"filePathFormat\": \"/js/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
				 "    \"fileUrlPrefix\": \"\",\n" +
				 "    \"fileMaxSize\": 5120000000,\n" +
				 "    \"fileAllowFiles\": [\n" +
				 "        \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" +
				 "        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
				 "        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" +
				 "        \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" +
				 "        \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" +
				 "    ],\n" +
				 "\n" +
				 "    \"imageManagerActionName\": \"listimage\",\n" +
				 "    \"imageManagerListPath\": \"/js/ueditor/jsp/upload/image/\",\n" +
				 "    \"imageManagerListSize\": 20,\n" +
				 "    \"imageManagerUrlPrefix\": \"\",\n" +
				 "    \"imageManagerInsertAlign\": \"none\",\n" +
				 "    \"imageManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\n" +
				 "\n" +
				 "    \"fileManagerActionName\": \"listfile\",\n" +
				 "    \"fileManagerListPath\": \"/js/ueditor/jsp/upload/file/\",\n" +
				 "    \"fileManagerUrlPrefix\": \"\",\n" +
				 "    \"fileManagerListSize\": 20,\n" +
				 "    \"fileManagerAllowFiles\": [\n" +
				 "        \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" +
				 "        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
				 "        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" +
				 "        \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" +
				 "        \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" +
				 "    ] \n" +
				 "\n" +
				 "}";
		 return result;
	    }  
	 
}
