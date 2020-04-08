package com.laptrinhjavaweb.dto;

public class MotocrycleDTO extends AbstractDTO<MotocrycleDTO> {
	
	private int quantity;
	private String description;
	private String name;
	private double price;
	private String thumbnail;
	private Long categoryId;
	private String context;
	private CategoryDTO category=new CategoryDTO();
	
	public MotocrycleDTO() {
		super();
	}
	
	public MotocrycleDTO( CategoryDTO category) {
		super();
		this.category = category;
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
		this.category = category;
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
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
}
