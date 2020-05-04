package com.laptrinhjavaweb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtil {

	public final String root = "D:\\Project\\DATN\\project-tttn-spring-mvc\\src\\main\\webapp\\resources";

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
}
