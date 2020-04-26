package com.laptrinhjavaweb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtil {

	public final String root = "C:\\Users\\ADMIN\\Desktop\\DATN\\project-tttn-spring-mvc\\src\\main\\webapp\\resources";

	public void writeOrUpdate(byte[] bytes, String path) {
		File file = new File(StringUtils.substringBeforeLast(root + path, "\\"));
		if (!file.exists()) {
			file.mkdir();
		}
		File writeFile = new File(root + path);
		try (FileOutputStream fileOutputStream = new FileOutputStream(writeFile)) {
			fileOutputStream.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static String upload(ServletContext servletContext, MultipartFile
	 * multipartFile) { try { SimpleDateFormat simpleDateFormat = new
	 * SimpleDateFormat("yyyyMMddHHmmss"); String
	 * fileName=simpleDateFormat.format(new Date()) +
	 * multipartFile.getOriginalFilename(); Path path =
	 * Paths.get(servletContext.getRealPath("/resources/images" + fileName));
	 * Files.write(path, multipartFile.getBytes()); return fileName; } catch
	 * (IOException e) { return null; } }
	 */
}
