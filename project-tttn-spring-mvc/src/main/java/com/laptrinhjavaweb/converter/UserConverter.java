package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setFullName(entity.getFullname());
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setStatus(entity.getStatus());
		try {
			result.setRole(entity.getRoles().get(0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setFullname(dto.getFullName());
		result.setUserName(dto.getUserName());
		result.setStatus(dto.getStatus());
		return result;
	}

	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setFullname(dto.getFullName());
		result.setUserName(dto.getUserName());
		result.setStatus(dto.getStatus());

		return result;
	}

}
