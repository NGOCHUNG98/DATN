package com.laptrinhjavaweb.dto;

import com.laptrinhjavaweb.entity.CategoryEntity;

public class MotocrycleDTO extends AbstractDTO<MotocrycleDTO> {

	
	private int quantity;
	private String description;
	private String name;
	private double price;
	private String thumbnail; 
	private Long categoryId;
	private String context;
	private String base64;
	private CategoryEntity categoryEntity;
	
	public MotocrycleDTO() {
		super();
	}
	
	public MotocrycleDTO(int quantity, String description, String name, double price, String thumbnail, String context,
			CategoryDTO category) {
		super();
		this.quantity = quantity;
		this.description = description;
		this.name = name;
		this.price = price;
		this.thumbnail = thumbnail;
		this.context = context;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	
	public String getBase64() {
		return base64.split(",")[1];
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}
}
