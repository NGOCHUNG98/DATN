package com.laptrinhjavaweb.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadUtil {

	private static final String ABS_PATH = "C:\\Users\\ADMIN\\Desktop\\DATN\\project-tttn-spring-mvc\\src\\main\\webapp\\resources\\images\\";
	private static String REAL_PATH = "";
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtil.class);

	public void uploadFile(HttpServletRequest request, MultipartFile file, Long id) {
		REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/images/");

		LOGGER.info(REAL_PATH);

		if (!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}

		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}

		try {
			file.transferTo(new File(REAL_PATH + id + ".jpg"));
			file.transferTo(new File(ABS_PATH + id + ".jpg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
