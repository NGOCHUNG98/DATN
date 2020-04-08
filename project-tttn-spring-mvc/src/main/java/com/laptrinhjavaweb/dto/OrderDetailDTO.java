package com.laptrinhjavaweb.dto;

public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO>{
	private int quantity;
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
	
	

}
