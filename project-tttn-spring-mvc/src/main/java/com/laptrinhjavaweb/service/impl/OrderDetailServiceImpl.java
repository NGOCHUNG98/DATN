package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.OrderDetailConverter;
import com.laptrinhjavaweb.converter.OrderDetailListConverter;
import com.laptrinhjavaweb.dto.OrderDetailDTO;
import com.laptrinhjavaweb.dto.OrderDetailListDTO;
import com.laptrinhjavaweb.entity.MotocrycleEntity;
import com.laptrinhjavaweb.entity.OrderDetailEntity;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.repository.MotocrycleRepository;
import com.laptrinhjavaweb.repository.OrderDetailRepository;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.service.IOrderDetailService;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {
	
	@Autowired
	private OrderDetailListConverter orderListConverter;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MotocrycleRepository motocrycleRepository;

	@Autowired
	private OrderDetailConverter orderDetailConverter;

	@Override
	@Transactional
	public OrderDetailDTO save(OrderDetailDTO dto) {
		OrderDetailEntity entity = new OrderDetailEntity();
		MotocrycleEntity motocrycleEntity = motocrycleRepository.findOne(dto.getMotocrycleId());
		OrderEntity orderEntity = orderRepository.findOne(dto.getOrderId());
		entity = orderDetailConverter.toEntity(dto);
		entity.setOrder(orderEntity);
		entity.setMotocrycleEntity(motocrycleEntity);
		return orderDetailConverter.toDto(orderDetailRepository.save(entity));
	}

	@Override
	public List<OrderDetailListDTO> fillAll(OrderDetailListDTO dto) {
		List<OrderDetailListDTO> model = new ArrayList<>();
		List<OrderDetailEntity> entities = orderDetailRepository.findAllOrderDetail();
		for (OrderDetailEntity item : entities) {
			OrderDetailListDTO detailListDTO = orderListConverter.toDto(item);
			model.add(detailListDTO);
		}
		return model;
	}

	@Override
	public List<OrderDetailDTO> findAll() {
		List<OrderDetailDTO> model = new ArrayList<>();
		List<OrderDetailEntity> entities = orderDetailRepository.findAll();
		for (OrderDetailEntity item : entities) {
			OrderDetailDTO detailDTO = orderDetailConverter.toDto(item);
			model.add(detailDTO);
		}
		return model;
	}

}
