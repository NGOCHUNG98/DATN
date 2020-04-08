package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.service.IMotocrycleService;

@RestController(value = "motocrycleApiOfAdmin")
public class MotocrycleAPI {
	@Autowired
	private IMotocrycleService motocrycleService;

	@PostMapping("/api/motocrycle")
	public MotocrycleDTO create(@RequestBody MotocrycleDTO dto) {
		return motocrycleService.save(dto);
	}

	@PutMapping("/api/motocrycle")
	public MotocrycleDTO udpate(@RequestBody MotocrycleDTO dto) {
		return motocrycleService.save(dto);
	}

	@DeleteMapping("/api/motocrycle")
	public void delete(@RequestBody long[] ids) {
		motocrycleService.delete(ids);
	}
}
