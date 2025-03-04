package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {
	private int id;
	private Date order_date;
	private Integer table_id;
	private List<PurchasedItemDto> items;
	
	
	public OrderDto(int id, Date order_date, Integer table_id, List<PurchasedItemDto> items) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.table_id = table_id;
		this.items = items;
	}
	public OrderDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Integer getTable_id() {
		return table_id;
	}
	public void setTable_id(Integer table_id) {
		this.table_id = table_id;
	}

	public List<PurchasedItemDto> getItems() {
		return items;
	}
	public void setItems(List<PurchasedItemDto> items) {
		this.items = items;
	}
	
	

	
}
