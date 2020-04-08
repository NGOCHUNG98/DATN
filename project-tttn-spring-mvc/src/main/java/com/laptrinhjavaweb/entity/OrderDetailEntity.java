package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billdetail")
public class OrderDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "motocrycle_id", nullable = false)
	private MotocrycleEntity motocrycleEntity;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private OrderEntity order;


	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public MotocrycleEntity getMotocrycleEntity() {
		return motocrycleEntity;
	}

	public void setMotocrycleEntity(MotocrycleEntity motocrycleEntity) {
		this.motocrycleEntity = motocrycleEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
