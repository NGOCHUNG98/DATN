package com.laptrinhjavaweb.service;

import java.util.HashMap;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.dto.MotocrycleDTO;


public interface IShoppingCartService {
	
	void create(MotocrycleDTO motorcycle, HashMap<Long, CartDTO> cart, long id);
	void delete(MotocrycleDTO motorcycle, HashMap<Long, CartDTO> cart, long id);
	void updateQuantity(HashMap<Long, CartDTO> cart, String[] quantity);
}