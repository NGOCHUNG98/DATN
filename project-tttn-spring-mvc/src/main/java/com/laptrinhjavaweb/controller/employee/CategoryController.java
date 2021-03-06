package com.laptrinhjavaweb.controller.employee;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {
	
	@Autowired
	private ICategoryService catgoryService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/nhan-vien-quan-tri/hang-san-xuat/danh-sach", method = RequestMethod.GET)
	public ModelAndView viewList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		CategoryDTO model=new CategoryDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView modelAndView = new ModelAndView("employee/category/list");
		Pageable pageable= new PageRequest(page-1, limit);
		model.setListResult(catgoryService.findAll(pageable));
		model.setTotalItem(catgoryService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message=messageUtil.getMessage(request.getParameter("message"));
			modelAndView.addObject("message", message.get("message"));
			modelAndView.addObject("alert", message.get("alert"));
		}
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@RequestMapping(value = "/nhan-vien-quan-tri/hang-san-xuat/danh-sach/chinh-sua", method = RequestMethod.GET)
	public ModelAndView viewList(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView modelAndView = new ModelAndView("employee/category/edit");
		CategoryDTO model=new CategoryDTO();
		if(id!=null) {
			model=catgoryService.findOne(id);
		}
		modelAndView.addObject("model", model);
		return modelAndView;
	}
}
