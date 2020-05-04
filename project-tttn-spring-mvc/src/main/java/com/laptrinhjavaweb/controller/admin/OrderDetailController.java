package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.OrderDetailDTO;
import com.laptrinhjavaweb.service.IOrderDetailService;

@Controller(value = "orderDetailControllerOfAdmin")
public class OrderDetailController {
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	/*
	 * @RequestMapping(value = "/quan-tri/hoa-don/danh-sach", method =
	 * RequestMethod.GET) public ModelAndView
	 * homePage(@ModelAttribute("orderDetailList") OrderDetailListDTO
	 * orderDetailList) { ModelAndView modelAndView = new
	 * ModelAndView("admin/report/list");
	 * orderDetailList.setListResult(orderDetailService.fillAll(orderDetailList));
	 * modelAndView.addObject("orderDetailService",orderDetailService);
	 * System.out.println(orderDetailService.toString()); return modelAndView; }
	 */
	@RequestMapping(value = "/nhan-vien-quan-tri/hoa-don/danh-sach", method = RequestMethod.GET)
	public ModelAndView viewList(@ModelAttribute("orderDetailList") OrderDetailDTO model) {
		ModelAndView modelAndView = new ModelAndView("admin/orderdetail/list");
		model.setListResult(orderDetailService.findAll());
		modelAndView.addObject("model",model);
		return modelAndView;
	}
}
