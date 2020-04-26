package com.laptrinhjavaweb.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.OrderConverter;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderConverter orderConverter;

	@Autowired
	private OrderRepository orderRepository;


	@Override
	@Transactional
	public OrderDTO save(OrderDTO dto) {
		OrderEntity entity = new OrderEntity();
		entity = orderConverter.toEntity(dto);
		return orderConverter.toDto(orderRepository.save(entity));
	}

}
