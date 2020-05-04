package com.laptrinhjavaweb.api.admin;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.service.IMotocrycleService;
import com.laptrinhjavaweb.util.UploadFileUtil;

@RestController(value = "motocrycleApiOfAdmin")
public class MotocrycleAPI {
	
	@Autowired
	private UploadFileUtil uploadFileUtil;
	
	@Autowired
	private IMotocrycleService motocrycleService;

	@PostMapping(value = "/api/motocrycle")
	public MotocrycleDTO create(@RequestBody MotocrycleDTO dto) {
		createOrEidt(dto);
		return motocrycleService.save(dto);
		
	}

	@PutMapping("/api/motocrycle")
	public MotocrycleDTO udpate(@RequestBody MotocrycleDTO dto) {
		createOrEidt(dto);
		return motocrycleService.save(dto);
	}

	@DeleteMapping("/api/motocrycle")
	public void delete(@RequestBody long[] ids) {
		motocrycleService.delete(ids);
	}
	
	public void createOrEidt(MotocrycleDTO dto) {
		try {
			byte[] decodeBase64 = Base64.getDecoder().decode(dto.getBase64().getBytes());
			uploadFileUtil.writeOrUpdate(decodeBase64, "\\images\\" + dto.getThumbnail());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
