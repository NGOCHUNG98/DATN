package com.laptrinhjavaweb.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CartDTO;

@Controller(value = "endOrderControllerOfWeb")
public class EndOrderController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/end-order", method = RequestMethod.GET)
	public ModelAndView endOrder(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("web/end");
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
		cart=new HashMap<Long, CartDTO>();
		session.setAttribute("cart", cart);
		return modelAndView;
	}
	
}
