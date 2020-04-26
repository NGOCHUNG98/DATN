package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.OrderDetailDTO;
import com.laptrinhjavaweb.dto.OrderDetailListDTO;

public interface IOrderDetailService {
	OrderDetailDTO save(OrderDetailDTO dto);
	
	List<OrderDetailListDTO> fillAll(OrderDetailListDTO dto);
	List<OrderDetailDTO> findAll();
}
