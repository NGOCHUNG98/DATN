package com.laptrinhjavaweb.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.dto.OrderDetailDTO;
import com.laptrinhjavaweb.service.IMotocrycleService;
import com.laptrinhjavaweb.service.IOrderDetailService;

@Controller(value = "orderDetailControllerOfAdmin")
public class OrderDetailController {

	@Autowired
	private IOrderDetailService orderDetailService;

	@Autowired
	private IMotocrycleService motorService;

	/*
	 * @RequestMapping(value = "/quan-tri/hoa-don/danh-sach", method =
	 * RequestMethod.GET) public ModelAndView
	 * homePage(@ModelAttribute("orderDetailList") OrderDetailListDTO
	 * orderDetailList) { ModelAndView modelAndView = new
	 * ModelAndView("admin/orderdetail/list");
	 * orderDetailList.setListResult(orderDetailService.fillAll(orderDetailList));
	 * modelAndView.addObject("orderDetailService",orderDetailService);
	 * System.out.println(orderDetailService.toString()); return modelAndView; }
	 */
	@RequestMapping(value = "/quan-tri/hoa-don/danh-sach", method = RequestMethod.GET)
	public ModelAndView viewlist(@ModelAttribute("model") OrderDetailDTO model) {
		ModelAndView modelAndView = new ModelAndView("admin/orderdetail/list");
		model.setListResult(orderDetailService.findAll(model));
		modelAndView.addObject("model", model);
		MotocrycleDTO motor = new MotocrycleDTO();
		List<MotocrycleDTO> listMotor = new ArrayList<MotocrycleDTO>();
		for (OrderDetailDTO id : model.getListResult()) {
			motor.setListResult(motorService.findDetailByMotocrycleId(id.getMotocrycleId()));
			for(MotocrycleDTO name : motor.getListResult()) {
				motor.setName(name.getName());
				listMotor.add(motor);
			}
		}
		modelAndView.addObject("motor", listMotor.toString());
		return modelAndView;
	}
}
