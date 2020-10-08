package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderInfoDto {

	private int id;
	private String order_no;
	@JsonFormat(pattern="dd/MM/yyyy") 
	private Date order_date;
	private Integer table_id;
	private Double totalprice;
	private Status status;



	public OrderInfoDto(int id, String order_no, Date order_date, Integer table_id, Double totalprice, Status status) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.order_date = order_date;
		this.table_id = table_id;
		this.totalprice = totalprice;
		this.status= status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
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

}
