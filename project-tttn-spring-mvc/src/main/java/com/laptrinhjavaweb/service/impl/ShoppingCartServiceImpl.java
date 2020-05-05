package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.dto.MotocrycleDTO;
import com.laptrinhjavaweb.service.IShoppingCartService;


@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

	@Override
	public void create(MotocrycleDTO motorcycle, HashMap<Long, CartDTO> cart, long id) {
		if (motorcycle != null) {
			if (cart.containsKey(id)) {
				CartDTO item = cart.get(id);
				item.setMotocrycle(motorcycle);
				item.setQuantity(item.getQuantity() + 1);
				cart.put(id, item);
			} else {
				CartDTO item = new CartDTO();
				item.setMotocrycle(motorcycle);
				item.setQuantity(1);
				cart.put(id, item);
			}
		}

	}

	@Override
	public void delete(MotocrycleDTO motorcycle, HashMap<Long, CartDTO> cart, long id) {
		cart.remove(id);

	}

	@Override
	public void updateQuantity(HashMap<Long, CartDTO> cart, String[] quantity) {
		try {
			int i=0;
			for (Map.Entry<Long, CartDTO> list : cart.entrySet()) {
				list.getValue().setQuantity(Integer.parseInt(quantity[i]));
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

}
