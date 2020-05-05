package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "userControllerOfClient")
public class UserController {

	@Autowired

	@Qualifier("passwordValidator")
	private Validator validator;

	@Autowired
	private IUserService userService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/thong-tin-ca-nhan", method = RequestMethod.GET)
	public ModelAndView profileUser(@ModelAttribute("user") UserDTO user,

			@RequestParam(value = "username", required = false) String username) {
		ModelAndView modelAndView = new ModelAndView("web/profileUser");
		if (username != "") {
			user = userService.findOneByUserName(username);
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("name", authentication.getName());
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/thay-doi-mat-khau", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("model") UserDTO model, @RequestParam(value = "username", required = false) String username, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelAndView = new ModelAndView("web/profileUser");
		
		modelAndView.addObject("user", model);
		return "redirect:/thong-tin-ca-nhan?username=" + authentication.getName() + "";
	}
	
	@RequestMapping(value = "/dang-ky-thanh-vien", method = RequestMethod.POST)
	public ModelAndView registrationUser(@ModelAttribute("registration") UserDTO user, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("web/home");
		user.setFullName(request.getParameter("fullName"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setStatus(1);
		userService.save(user);
		return modelAndView;
	}

}
