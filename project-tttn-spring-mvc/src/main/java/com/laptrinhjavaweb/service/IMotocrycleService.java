package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.MotocrycleDTO;

public interface IMotocrycleService {
	MotocrycleDTO findOne(long id);
	List<MotocrycleDTO> findDetailByMotocrycleId(Long id);
	List<MotocrycleDTO> findByNameMotocrycle(String name);
	List<MotocrycleDTO> findByCategoryId(Long categoryId);
	MotocrycleDTO save(MotocrycleDTO dto);
	List<MotocrycleDTO> findAll();
	List<MotocrycleDTO> findAll(Pageable pageable);
	int getTotalItem();
	void delete(long[] ids);
}
