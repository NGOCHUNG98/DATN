package com.laptrinhjavaweb.controller.admin;

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

import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IMotocrycleService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "motocrycleControllerOfAdmin")
public class MotocrycleController {

	@Autowired
	private IMotocrycleService motocrycleService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/quan-tri/xe-may/danh-sach", method = RequestMethod.GET)
	public ModelAndView viewList(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		MotocrycleDTO model = new MotocrycleDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView modelAndView = new ModelAndView("admin/moto/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(motocrycleService.findAll(pageable));
		model.setTotalItem(motocrycleService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		modelAndView.addObject("categories", categoryService.findAllCategory());
		modelAndView.addObject("category", categoryService.findAll());
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			modelAndView.addObject("message", message.get("message"));
			modelAndView.addObject("alert", message.get("alert"));
		}
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@RequestMapping(value = "/quan-tri/xe-may/danh-sach/chinh-sua", method = RequestMethod.GET)
	public ModelAndView viewList(@RequestParam(value = "id", required = false) Long id){
		ModelAndView modelAndView = new ModelAndView("admin/moto/edit");
		MotocrycleDTO model = new MotocrycleDTO();
		if (id != null) {
			model = motocrycleService.findOne(id);
		}
		modelAndView.addObject("categories", categoryService.findAllCategory());
		modelAndView.addObject("model", model);
		return modelAndView;
	}
}
