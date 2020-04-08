package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IMotocrycleService;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IMotocrycleService motocrycleService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute("category") CategoryDTO category, @RequestParam("page") int page,
			@RequestParam("limit") int limit, @ModelAttribute("model") MotocrycleDTO model,
			@RequestParam(value = "id", required = false) Long id) {

		model.setPage(page);
		model.setLimit(limit);

		ModelAndView modelAndView = new ModelAndView("web/home");

		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(motocrycleService.findAll(pageable));
		model.setTotalItem(motocrycleService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));

		category.setListResult(categoryService.findAll());
		modelAndView.addObject("category", category);
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET) public
	 * ModelAndView login() { ModelAndView modelAndView = new ModelAndView("login");
	 * return modelAndView; }
	 */
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login2");
		return modelAndView;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/dang-ky-thanh-vien", method = RequestMethod.POST)
	public ModelAndView registrationUser(@ModelAttribute("registration") UserDTO user, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("web/home");
		user.setFullName(request.getParameter("fullName"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("passwork"));
		user.setStatus(1);
		userService.save(user);
		return modelAndView;
	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
