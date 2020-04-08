package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.entity.MotocrycleEntity;

@Component
public class MotocrycleConverter {

	public MotocrycleDTO toDto(MotocrycleEntity entity) {

		MotocrycleDTO result = new MotocrycleDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		result.setQuantity(entity.getQuantity());
		result.setPrice(entity.getPrice());
		result.setThumbnail(entity.getThumbnail());
		result.setContext(entity.getContext());
		result.setCategoryId(entity.getCategoryEntity().getId());
		return result;

	}

	public MotocrycleEntity toEntity( MotocrycleDTO dto) {

		MotocrycleEntity result = new MotocrycleEntity();
		result.setName(dto.getName());
		result.setDescription(dto.getDescription());
		result.setQuantity(dto.getQuantity());
		result.setPrice(dto.getPrice());
		result.setContext(dto.getContext());
		result.setThumbnail(dto.getThumbnail());
		return result;

	}
	
	public MotocrycleEntity toEntity(MotocrycleEntity result, MotocrycleDTO dto) {
		result.setName(dto.getName());
		result.setDescription(dto.getDescription());
		result.setQuantity(dto.getQuantity());
		result.setPrice(dto.getPrice());
		result.setContext(dto.getContext());
		result.setThumbnail(dto.getThumbnail());
		return result;

	}

}
