package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.MotocrycleConverter;
import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.MotocrycleEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.MotocrycleRepository;
import com.laptrinhjavaweb.service.IMotocrycleService;

@Service
public class MotocrycleServiceimpl implements IMotocrycleService {

	@Autowired
	private MotocrycleRepository motocrycleRepository;

	@Autowired
	private MotocrycleConverter motocrycleConverter;

	@Autowired
	private CategoryRepository catgoryRepository;

	public MotocrycleServiceimpl() {

	}


	@Override
	public List<MotocrycleDTO> findAll() {
		List<MotocrycleDTO> model = new ArrayList<>();
		List<MotocrycleEntity> entities = motocrycleRepository.findAll();
		for (MotocrycleEntity item : entities) {
			MotocrycleDTO motocrycleDTO = motocrycleConverter.toDto(item);
			model.add(motocrycleDTO);
		}
		return model;
	}

	@Override
	public MotocrycleDTO findOne(long id) {
		MotocrycleEntity entity = motocrycleRepository.findOne(id);
		return motocrycleConverter.toDto(entity);
	}

	@Override
	public int getTotalItem() {
		return (int) motocrycleRepository.count();
	}
	
	@Override
	@Transactional
	public MotocrycleDTO save(MotocrycleDTO dto) {
		CategoryEntity categoryEntity = catgoryRepository.findOneById(dto.getCategoryId());
		MotocrycleEntity entity = new MotocrycleEntity();
		if (dto.getId() != null) {
			MotocrycleEntity oldMotocrycle = motocrycleRepository.findOne(dto.getId());
			oldMotocrycle.setCategoryEntity(categoryEntity);
			entity = motocrycleConverter.toEntity(oldMotocrycle, dto);
		} else {
			entity = motocrycleConverter.toEntity(dto);
			entity.setCategoryEntity(categoryEntity);
		}
		return motocrycleConverter.toDto(motocrycleRepository.save(entity));
	}

	@Override
	public List<MotocrycleDTO> findAll(Pageable pageable) {
		List<MotocrycleDTO> result = new ArrayList<MotocrycleDTO>();
		List<MotocrycleEntity> entities = motocrycleRepository.findAll(pageable).getContent();
		for (MotocrycleEntity item : entities) {
			MotocrycleDTO dto = motocrycleConverter.toDto(item);
			result.add(dto);
		}
		return result;
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			motocrycleRepository.delete(id);
		}
	}

	@Override
	public List<MotocrycleDTO> findByCategoryId(Long categoryId) {
		List<MotocrycleDTO> result = new ArrayList<MotocrycleDTO>();
		List<MotocrycleEntity> entities = motocrycleRepository.findByCategoryId(categoryId);
		for (MotocrycleEntity item : entities) {
			MotocrycleDTO dto = motocrycleConverter.toDto(item);
			result.add(dto);
		}
		return result;

	}

	@Override
	public List<MotocrycleDTO> findDetailByMotocrycleId(Long id) {
		List<MotocrycleDTO> result = new ArrayList<MotocrycleDTO>();
		List<MotocrycleEntity> entities = motocrycleRepository.findDetailByMotorycleId(id);
		for (MotocrycleEntity item : entities) {
			MotocrycleDTO dto = motocrycleConverter.toDto(item);
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<MotocrycleDTO> findByNameMotocrycle(String name) {
		List<MotocrycleDTO> result = new ArrayList<MotocrycleDTO>();
		List<MotocrycleEntity> entities = motocrycleRepository.findByNameMotocrycle(name);
		for (MotocrycleEntity item : entities) {
			MotocrycleDTO dto = motocrycleConverter.toDto(item);
			result.add(dto);
		}
		return result;
	}

}
