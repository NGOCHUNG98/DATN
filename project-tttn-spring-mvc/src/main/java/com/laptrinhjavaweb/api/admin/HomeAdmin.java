package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IRolesService;
import com.laptrinhjavaweb.service.IUserService;

@RestController
public class HomeAdmin {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRolesService roleService;

	@GetMapping("/admin/home")
	public ModelAndView homePage(@ModelAttribute("model") UserDTO model) {
		ModelAndView modelAndView = new ModelAndView("admin/home");
		model.setListResult(userService.findAllByEmployee());
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@GetMapping("/admin/action")
	public ModelAndView action(@RequestParam(value = "id", required = false) Long id, UserDTO model) {
		ModelAndView modelAndView = new ModelAndView("admin/editOrAdd");
		if (id != null) {
			model = userService.findOne(id);
		}
		modelAndView.addObject("role", roleService.findAllRoles());
		modelAndView.addObject("model", model);
		return modelAndView;
	}
	
	@PutMapping("/api/admin/user")
	public UserDTO update(@RequestBody UserDTO dto) {
		return userService.saveAdmin(dto);
	}

}
