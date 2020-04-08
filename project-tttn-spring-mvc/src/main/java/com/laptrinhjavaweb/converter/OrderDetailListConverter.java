package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.OrderDetailListDTO;
import com.laptrinhjavaweb.entity.OrderDetailEntity;

@Component
public class OrderDetailListConverter {

	public OrderDetailListDTO toDto(OrderDetailEntity entity) {
		OrderDetailListDTO result = new OrderDetailListDTO();
		result.setCustomer_name(entity.getOrder().getCustomerName());
		result.setCustomer_address(entity.getOrder().getCustomerAddress());
		result.setCustomer_phone(entity.getOrder().getCustomerPhone());
		result.setOrder_date(entity.getOrder().getOrderDate());
		result.setStatus(entity.getOrder().isStatus());
		result.setThumbnail(entity.getMotocrycleEntity().getThumbnail());
		result.setName(entity.getMotocrycleEntity().getName());
		result.setPrice(entity.getMotocrycleEntity().getPrice());
		result.setQuantity(entity.getQuantity());
		return result;
	}
}
