package com.example.demo.dto;

public class PurchasedItemDto {
	private Integer id;
	private Integer quantity;

	public PurchasedItemDto() {
		super();
	}

	public PurchasedItemDto(Integer id, Integer quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
