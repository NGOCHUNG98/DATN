package com.laptrinhjavaweb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryUtil {
	
	@Autowired
	private ICategoryService categoryService;
	
	public void CategoryInterceptor(ModelAndView modelAndView) {
		CategoryDTO category = new CategoryDTO();
		category.setListResult(categoryService.findAll());
		modelAndView.addObject("category", category);
	}

}
