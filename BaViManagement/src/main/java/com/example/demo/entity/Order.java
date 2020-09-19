package com.example.demo.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.dto.OrderDto;

@Entity
@javax.persistence.Table(name="_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "order_no")
	private int order_no;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "order_date")
	private Date order_date;
	
//	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "table_id")
	private Table table_id;
	
//	@JsonIgnore
	@OneToMany(mappedBy = "order_id")
	private List<OrderDetail> orderDetails;
	
	private Double totalPrice;


	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order(int order_no, Date order_date, Table table_id, List<OrderDetail> orderDetails) {
		super();
		this.order_no = order_no;
		this.order_date = order_date;
		this.table_id = table_id;
		this.orderDetails = orderDetails;
	}
	
	public Order(OrderDto orderDto, Table table_id) {
		super();
		this.order_no = orderDto.getOrder_no();
		
		Date TODAY=  DateUtils.truncate(new Date() , Calendar.DAY_OF_MONTH);
		orderDto.setOrder_date(TODAY);
		this.order_date = orderDto.getOrder_date();
		this.table_id = table_id;
	}


	public Order() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getOrder_no() {
		return order_no;
	}


	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}


	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	public Table getTable_id() {
		return table_id;
	}


	public void setTable_id(Table table_id) {
		this.table_id = table_id;
	}


	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
