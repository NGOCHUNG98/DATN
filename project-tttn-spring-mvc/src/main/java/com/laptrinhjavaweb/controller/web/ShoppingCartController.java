package com.laptrinhjavaweb.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.service.IMotocrycleService;

@Controller(value = "shoppingCartControllerOfWeb")
public class ShoppingCartController {

	@Autowired
	private IMotocrycleService motocrycleService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/mua-hang", method = RequestMethod.GET)
	public ModelAndView buy(@RequestParam(value = "id", required = false) Long id, ModelMap mm, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
			if (cart == null) {
				cart = new HashMap<>();
			}
			MotocrycleDTO motocrycle = new MotocrycleDTO();
			motocrycle = motocrycleService.findOne(id);
			if (motocrycle != null) {
				if (cart.containsKey(id)) {
					CartDTO item = cart.get(id);
					item.setMotocrycle(motocrycle);
					item.setQuantity(item.getQuantity() + 1);
					cart.put(id, item);
				} else {
					CartDTO item = new CartDTO();
					item.setMotocrycle(motocrycle);
					item.setQuantity(1);
					cart.put(id, item);
				}
			}
			session.setAttribute("cart", cart);
			session.setAttribute("myCartTotal", totalPrice(cart));
			session.setAttribute("myCartNum", cart.size());
		}
		return new ModelAndView("web/cart");
	}

	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("web/cart");
		return modelAndView;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/gio-hang/xoa-hang", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam(value = "id", required = false) Long id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("web/cart");
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<>();
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		session.setAttribute("cart", cart);
		session.setAttribute("myCartTotal", totalPrice(cart));
		session.setAttribute("myCartNum", cart.size());
		return modelAndView;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cap-nhap-so-luong")
	public ModelAndView update(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("web/cart");
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
		String[] quantity = request.getParameterValues("quantity");
		try {
			int i=0;
			for (Map.Entry<Long, CartDTO> list : cart.entrySet()) {
				list.getValue().setQuantity(Integer.parseInt(quantity[i]));
				i++;
				//cart.setQuantity(Integer.parseInt(quantity[i]));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		session.setAttribute("cart", cart);
		return modelAndView;
	}

	public double totalPrice(HashMap<Long, CartDTO> cart) {
		int count = 0;
		for (Map.Entry<Long, CartDTO> list : cart.entrySet()) {
			count += list.getValue().getMotocrycle().getPrice() * list.getValue().getQuantity();
		}
		return count;
	}
}
