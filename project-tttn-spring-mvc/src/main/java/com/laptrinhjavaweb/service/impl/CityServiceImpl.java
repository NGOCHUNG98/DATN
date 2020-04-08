package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CityConverter;
import com.laptrinhjavaweb.dto.CityDTO;
import com.laptrinhjavaweb.entity.CityEntity;
import com.laptrinhjavaweb.repository.CityRepository;
import com.laptrinhjavaweb.service.ICityService;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CityConverter cityConverter;

	@Override
	public List<CityDTO> findAll() {
		List<CityDTO> model = new ArrayList<>();
		List<CityEntity> entities = cityRepository.findAll();
		for (CityEntity item : entities) {
			CityDTO cityDTO = cityConverter.toDto(item);
			model.add(cityDTO);
		}
		return model;
	}

}
