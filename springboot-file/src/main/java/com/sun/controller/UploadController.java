package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.utils.BaseUtil;
import com.sun.utils.QRCodeUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.sun.utils.UploadFileUtil;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
	@PostMapping("/img")
	public String uploadImage(@RequestBody String base) {
		JSONObject json = JSONObject.parseObject(base);
		String resutl = json.get("base").toString();
		System.out.println(resutl);
		BaseUtil.GenerateImage(resutl,"/Users/wilson/Downloads/2.jpeg");
		return "success";
	}
	@GetMapping("/img")
	public String getImage() {
		String result = BaseUtil.GetImageStr("/Users/wilson/Downloads/1.jpeg");
		return result;
	}


//	@GetMapping("creatQrCode")
//	public void getQRCode(HttpServletResponse response) {
//		String codeContent = "https://www.baidu.com/";
//		String note="广东省深圳市南山区西里镇前海自贸区105栋205号";
//		try {
//			/**
//			 * 调用工具类生成二维码并输出到输出流中
//			 */
//			response.setHeader("Content-Type", "application/octet-stream");
//			response.setHeader("Content-Disposition", "attachment;filename=" + "aa.png");
//			BufferedImage image = QRCodeUtil.drawLogoQRCode(new File("/Users/wilson/Desktop/1.jpg"),codeContent,note);
//			ImageIO.write(image, "PNG", response.getOutputStream());
//		}  catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	@GetMapping("all")
	public void getAllQRCode(HttpServletResponse response) {
		String codeContent = "https://www.baidu.com/";
		String note = "广东省深圳市南山区西里镇前海自贸区105栋205号";
		try {
			/**
			 * 调用工具类生成二维码并输出到输出流中
			 */
			response.setHeader("Content-Type", "application/zip");
			response.setHeader("Content-Disposition", "attachment;filename=" + "aa.zip");

			OutputStream outputStream = response.getOutputStream();
			ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

			for (int i=0;i<2;i++){
				ZipEntry entry = new ZipEntry(i+".jpg");
				zipOutputStream.putNextEntry(entry);
				BufferedImage image = QRCodeUtil.drawLogoQRCode(null, codeContent, note);
				ImageIO.write(image, "PNG", zipOutputStream);
			}

			zipOutputStream.flush();
			zipOutputStream.close();
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
