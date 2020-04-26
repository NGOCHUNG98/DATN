package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CityDTO;
import com.laptrinhjavaweb.entity.CityEntity;

@Component
public class CityConverter {
	
	public CityDTO toDto(CityEntity entity) {
		CityDTO result=new CityDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		return result;
	}

}
