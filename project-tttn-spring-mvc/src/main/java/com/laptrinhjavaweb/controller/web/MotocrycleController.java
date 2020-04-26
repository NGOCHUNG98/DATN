package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.service.IMotocrycleService;

@Controller(value = "motocrycleControllerOfWeb")
public class MotocrycleController {
	
	@Autowired
	private IMotocrycleService motocrycleService;


	@RequestMapping(value = "/danh-sach-xe-may-theo-hang-san-xuat", method = RequestMethod.GET)
	public ModelAndView viewList(@RequestParam(value = "id", required = false) Long categoryId) {
		ModelAndView modelAndView = new ModelAndView("web/listByID");
		MotocrycleDTO model = new MotocrycleDTO();
		model.setListResult(motocrycleService.findByCategoryId(categoryId));
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@RequestMapping(value = "/chi-tiet-xe-may", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView modelAndView = new ModelAndView("web/detail");
		MotocrycleDTO model = new MotocrycleDTO();
		model.setListResult(motocrycleService.findDetailByMotocrycleId(id));
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@RequestMapping(value = "/tim-kiem-xe-may", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "name", required = false) String name) {
		ModelAndView modelAndView = new ModelAndView("web/home");
		MotocrycleDTO model = new MotocrycleDTO();
		model.setListResult(motocrycleService.findByNameMotocrycle(name));
		modelAndView.addObject("model", model);
		return modelAndView;
	}

}
