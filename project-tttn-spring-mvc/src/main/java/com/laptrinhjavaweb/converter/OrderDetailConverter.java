package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.OrderDetailDTO;
import com.laptrinhjavaweb.entity.OrderDetailEntity;

@Component
public class OrderDetailConverter {
	
	public OrderDetailDTO toDto(OrderDetailEntity entity) {
		OrderDetailDTO result=new OrderDetailDTO();
		result.setId(entity.getId());
		result.setQuantity(entity.getQuantity());
		result.setMotocrycleId(entity.getMotocrycleEntity().getId());
		result.setOrderId(entity.getOrder().getId());
		result.setMotocrycle(entity.getMotocrycleEntity());
		result.setOrder(entity.getOrder());
		return result;
	}

	public OrderDetailEntity toEntity(OrderDetailDTO dto) {
		OrderDetailEntity result=new OrderDetailEntity();
		result.setQuantity(dto.getQuantity());
		return result;
	}
}
