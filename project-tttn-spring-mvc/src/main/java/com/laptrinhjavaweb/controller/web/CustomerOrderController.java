package com.laptrinhjavaweb.controller.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.OrderDetailDTO;
import com.laptrinhjavaweb.service.IOrderDetailService;
import com.laptrinhjavaweb.service.IOrderService;
import com.laptrinhjavaweb.util.SecurityUtils;

@Controller(value = "inFoCustomerControllerOfWeb")
public class CustomerOrderController {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IOrderDetailService orderDetailService;

	/*
	 * @Autowired private ICityService cityService;
	 */
	ShoppingCartController shopping = new ShoppingCartController();
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView pay(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("web/pay");
		try {
			File file=new File("D:\\Project\\DATN\\project-tttn-spring-mvc\\src\\main\\webapp\\resources\\json\\city.json");
			JSONParser parser = new JSONParser();
			BufferedReader in = new BufferedReader(
					   new InputStreamReader(
			                      new FileInputStream(file), "UTF-8"));
			Object object = parser.parse(in);
			JSONObject LtsItem = (JSONObject) object;
			JSONArray jsonArray = (JSONArray) LtsItem.get("LtsItem");
			Iterator<JSONObject> iterator = jsonArray.iterator();
			List<String> listTitle=new ArrayList<String>();
			while (iterator.hasNext()) {
				String title=(String) iterator.next().get("Title");
				listTitle.add(title);
			}
			modelAndView.addObject("title", listTitle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String name = SecurityUtils.getPrincipal().getFullname();
		modelAndView.addObject("name", name);
		if (session != null) {
			HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
			session.setAttribute("cart", cart);
			return modelAndView;
		}
		return modelAndView;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dat-hang", method = RequestMethod.POST)
	public ModelAndView order(HttpSession session, @ModelAttribute("order") OrderDTO orderDTO,
			HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		orderDTO.setCustomerName(request.getParameter("customerName"));
		orderDTO.setNote(request.getParameter("note"));
		orderDTO.setCustomerAddress(request.getParameter("customerAddress"));
		orderDTO.setCustomerPhone(request.getParameter("customerPhone"));
		orderDTO.setOrderDate(new Timestamp(new Date().getTime()));
		orderDTO.setNote(request.getParameter("note"));
		orderDTO.setStatus(1);
		ModelAndView modelAndView = new ModelAndView("web/confirmCustomer");
		if (session != null && authentication != null) {
			HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
			if (cart == null) {
				cart = new HashMap<>();
			}
			session.setAttribute("cart", cart);
			session.setAttribute("myCartTotal", shopping.totalPrice(cart));
			orderDTO=orderService.save(orderDTO);
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
			for (Map.Entry<Long, CartDTO> entry : cart.entrySet()) {
				//OrderEntity entity=new OrderEntity();
				orderDetailDTO.setOrderId(orderDTO.getId());
				orderDetailDTO.setMotocrycleId(entry.getValue().getMotocrycle().getId());
				orderDetailDTO.setQuantity(entry.getValue().getQuantity());
				orderDetailService.save(orderDetailDTO);
			}
			cart=new HashMap<Long, CartDTO>();
			
		}
		modelAndView.addObject("orderDTO", orderDTO);
		return modelAndView;
	}
}
