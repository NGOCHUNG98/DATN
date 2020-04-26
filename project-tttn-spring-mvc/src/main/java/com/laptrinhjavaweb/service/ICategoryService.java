package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll(Pageable pageable);
	List<CategoryDTO> findAll();
	int getTotalItem();
	CategoryDTO save(CategoryDTO dto);
	CategoryDTO findOne(long id);
	void delete(long[] ids);
	Map<Long, String> findAllCategory();
}
