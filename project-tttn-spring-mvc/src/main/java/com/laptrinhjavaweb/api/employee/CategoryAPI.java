package com.laptrinhjavaweb.api.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.service.ICategoryService;

@RestController(value = "categoryApiOfAdmin")
public class CategoryAPI {

	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping("/api/category")
	public CategoryDTO create(@RequestBody CategoryDTO dto) {
		return categoryService.save(dto);
	}
	
	@PutMapping("/api/category")
	public CategoryDTO update(@RequestBody CategoryDTO dto) {
		return categoryService.save(dto);
	}
	
	@DeleteMapping("/api/category")
	public void delete(@RequestBody long[] ids) {
		categoryService.delete(ids);
	}
	
}
