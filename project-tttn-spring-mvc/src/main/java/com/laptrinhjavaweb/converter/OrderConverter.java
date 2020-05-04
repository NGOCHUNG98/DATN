package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.entity.OrderEntity;

@Component
public class OrderConverter {
	
	public OrderDTO toDto(OrderEntity orderEntity) {
		OrderDTO result=new OrderDTO();
		result.setId(orderEntity.getId());
		result.setCustomerName(orderEntity.getCustomerName());
		result.setCustomerAddress(orderEntity.getCustomerAddress());
		result.setCustomerPhone(orderEntity.getCustomerPhone());
		result.setNote(orderEntity.getNote());
		result.setOrderDate(orderEntity.getOrderDate());
		result.setStatus(orderEntity.getStatus());
		//result.setUserId(orderEntity.getUser().getId());
		return result;
	}
	
	public OrderEntity toEntity(OrderDTO dto) {
		OrderEntity result=new OrderEntity();
		result.setCustomerName(dto.getCustomerName());
		result.setCustomerAddress(dto.getCustomerAddress());
		result.setCustomerPhone(dto.getCustomerPhone());
		result.setNote(dto.getNote());
		result.setOrderDate(dto.getOrderDate());
		result.setStatus(dto.getStatus());
		return result;
	}
}
