package com.laptrinhjavaweb.dto;

public class CartDTO extends AbstractDTO<CartDTO>{
	
	private int quantity;
	private MotocrycleDTO motocrycle=new MotocrycleDTO();
	public CartDTO() {
		super();
	}

	public CartDTO(int quantity, MotocrycleDTO motocrycle) {
		super();
		this.quantity = quantity;
		this.motocrycle = motocrycle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MotocrycleDTO getMotocrycle() {
		return motocrycle;
	}

	public void setMotocrycle(MotocrycleDTO motocrycle) {
		this.motocrycle = motocrycle;
	}

}
