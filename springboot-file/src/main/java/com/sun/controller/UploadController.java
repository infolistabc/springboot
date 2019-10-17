package com.sun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sun.utils.UploadFileUtil;

@RestController
public class UploadController {
	
	@RequestMapping("/uploadmulti")
	public String uploadMultiFile(MultipartFile[] file) {
		for (MultipartFile vo : file) {
			String newFileName = UploadFileUtil.createNewFileName(vo);
			System.out.println("提交的参数" + vo.getName());
			//判断文件是否上传成功
			if( UploadFileUtil.upload(vo, newFileName)) {
				return "上传成功";
			}
		}
		return "FAIL";
	}

	@RequestMapping("/upload")
	public String uploadFile(MultipartFile file) {
		String newFileName = UploadFileUtil.createNewFileName(file);
		if (UploadFileUtil.upload(file, newFileName)) {
			return "文件上传成功";
		}
		return "FAIL";
	}
}
