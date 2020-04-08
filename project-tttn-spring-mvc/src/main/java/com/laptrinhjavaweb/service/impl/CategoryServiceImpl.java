package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	CategoryConverter categoryConverter;

	@Override
	public Map<Long, String> findAllCategory() {
		Map<Long, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item : entities) {
			result.put(item.getId(), item.getName());
		}
		return result;
	}

	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> model = new ArrayList<>();
		List<CategoryEntity> categoryEntities = categoryRepository.findAll(pageable).getContent();
		for (CategoryEntity item : categoryEntities) {
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			model.add(categoryDTO);
		}
		return model;
	}

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		if (dto.getId() != null) {
			CategoryEntity oldCategory=categoryRepository.findOne(dto.getId());
			entity=categoryConverter.toEntity(oldCategory, dto);
		}else {
			entity=categoryConverter.toEntity(dto);
		}
		return categoryConverter.toDto(categoryRepository.save(entity));
	}

	@Override
	public void delete(long[] ids) {
		for(long id:ids) {
			categoryRepository.delete(id);
		}
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> model = new ArrayList<>();
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		for (CategoryEntity item : categoryEntities) {
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			model.add(categoryDTO);
		}
		return model;
	}

	@Override
	public int getTotalItem() {
		return (int) categoryRepository.count();
	}

	@Override
	public CategoryDTO findOne(long id) {
		CategoryEntity entity=categoryRepository.findOne(id);
		return categoryConverter.toDto(entity);
	}

}
