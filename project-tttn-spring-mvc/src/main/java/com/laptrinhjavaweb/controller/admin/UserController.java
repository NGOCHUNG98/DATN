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

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "userControllerOfAdmin")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/danh-sach", method = RequestMethod.GET)
	public ModelAndView viewList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		UserDTO model=new UserDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView modelAndView = new ModelAndView("admin/user/list");
		Pageable pageable=new PageRequest(page-1, limit);
		model.setListResult(userService.findAll(pageable));
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message=messageUtil.getMessage(request.getParameter("message"));
			modelAndView.addObject("message", message.get("message"));
			modelAndView.addObject("alert", message.get("alert"));
		}
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@RequestMapping(value = "/quan-tri/nguoi-dung/danh-sach/chinh-sua", method = RequestMethod.GET)
	public ModelAndView viewList(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView modelAndView = new ModelAndView("admin/user/edit");
		UserDTO model=new UserDTO();
		if(id!=null) {
			model=userService.findOne(id);
		}
		modelAndView.addObject("model", model);
		return modelAndView;
	}
}
