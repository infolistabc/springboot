package com.sun.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @author wilson
 * @Date 2018/21/25
 */
@Controller
public class UploadFileUtil {

	
	/**
	 *	保存文件方法
	 * @param file  上传文件的对象
	 * @param fileName   文件名称
	 * @return
	 */
	public static boolean upload(MultipartFile file, String fileName) {
		InputStream input = null;
		OutputStream output = null;
		// 上传文件的标志
		boolean flag = true;
		try {
			// 取得上传文件的输入流对象
			input = file.getInputStream();
			// 获取保存文件的路径
			String path = getDir() + fileName;
			// 创建一个File类的对象，判断文件的父目录是否存在，不存在则创建一个目录
			File file1 = new File(path);
			if (!file1.getParentFile().exists()) {
				file1.getParentFile().mkdirs();
			}
			// 输出流对象
			output = new FileOutputStream(file1);
			// 声明字节数组
			byte[] by = new byte[2048];
			int temp = 0;
			while ((temp = input.read(by)) != -1) {
				output.write(by, 0, temp);
			}
			output.close();
			input.close();
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 	定义生成新文件的名称，避免上传的文件名称相同从而把原来的文件覆盖
	 * 
	 * @param file 上传文件封装类
	 * @return 生成新的文件名称
	 */
	public static String createNewFileName(MultipartFile file) {
		String fileName = null;
		if (!file.isEmpty()) {
			fileName = UUID.randomUUID() + "." + file.getContentType().split("/")[1];
		}
		return fileName;
	}

	/**
	 * 	定义保存文件的目录
	 * 
	 * @return
	 */
	public static String getDir() {
		return "/usr/local/study";
	}
}

