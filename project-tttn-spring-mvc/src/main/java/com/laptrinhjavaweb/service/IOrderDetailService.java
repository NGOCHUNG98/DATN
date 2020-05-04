package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.OrderDetailDTO;

public interface IOrderDetailService {
	OrderDetailDTO save(OrderDetailDTO dto);
	
	List<OrderDetailDTO> findAll();
}
