package com.example.demo.dto;

public class BillDto {
	private Integer id;
	private String item_name;
	private String item_photos;
	private Double item_price;
	private int item_quantity;
	private Double total_price;
	
	
	public BillDto(Integer id,String item_name, String item_photos, Double item_price, int item_quantity, Double total_price) {
		super();
		this.id= id;
		this.item_name = item_name;
		this.item_photos = item_photos;
		this.item_price = item_price;
		this.item_quantity = item_quantity;
		this.total_price = total_price;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_photos() {
		return item_photos;
	}
	public void setItem_photos(String item_photos) {
		this.item_photos = item_photos;
	}
	public Double getItem_price() {
		return item_price;
	}
	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}



}
