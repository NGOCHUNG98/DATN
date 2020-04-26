package com.laptrinhjavaweb.dto;

import com.laptrinhjavaweb.entity.MotocrycleEntity;
import com.laptrinhjavaweb.entity.OrderEntity;

public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO>{
	private int quantity;
	private MotocrycleEntity motocrycle;
	private OrderEntity order;
	private Long motocrycleId;
	private Long orderId;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getMotocrycleId() {
		return motocrycleId;
	}
	public void setMotocrycleId(Long motocrycleId) {
		this.motocrycleId = motocrycleId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public MotocrycleEntity getMotocrycle() {
		return motocrycle;
	}
	public void setMotocrycle(MotocrycleEntity motocrycle) {
		this.motocrycle = motocrycle;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}	

}
