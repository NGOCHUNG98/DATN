package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@RestController(value = "userApiOfAdmin")
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user")
	public UserDTO create(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	
	@PutMapping("/api/user")
	public UserDTO update(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	
	@DeleteMapping("/api/user")
	public void delete(@RequestBody long[] ids) {
		userService.delete(ids);
	}
	
}
