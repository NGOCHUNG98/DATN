package com.laptrinhjavaweb.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.MyItem;
import com.laptrinhjavaweb.service.IReportOrderService;

@Controller(value = "ReportOfAdmin")
public class ReportOrderController {

	@Autowired
	private IReportOrderService reportService;

	@RequestMapping(value = "/quan-tri/thong-ke", method = RequestMethod.GET)
	public ModelAndView viewReport(ModelMap mm, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("admin/report/report");
		Date date = new Date();
		MyItem myItem = new MyItem();
		myItem.setListResult(reportService.reportOrder(date, 10));
		System.out.println(myItem);
		mm.put("myItem", myItem);
		return modelAndView;
	}
}
