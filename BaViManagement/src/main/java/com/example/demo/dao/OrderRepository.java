package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.BillDto;
import com.example.demo.dto.OrderInfoDto;
import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	//	GET BILL BY ORDER ID
	@Query("select new com.example.demo.dto.BillDto(od.id,it.name,it.photos,it.price,od.quantity,o.totalPrice) "
			+ "from Order o join o.orderDetails od join od.items it "
			+ "where o.id= :id"
			)
	public List<BillDto> getBill(Integer id);
	
	
	@Query("select new com.example.demo.dto.OrderInfoDto(o.id, o.order_no, o.order_date, tb.id,o.totalPrice,o.status) "
			+ "from Order o join o.table_id tb")
	public List<OrderInfoDto> listOrderInfo();
	
	@Query("select new com.example.demo.dto.OrderInfoDto(o.id, o.order_no, o.order_date, tb.id,o.totalPrice,o.status) "
			+ "from Order o join o.table_id tb "
			+ "where o.id= :id")
	public OrderInfoDto getOrderInfo(Integer id);
	
	
	@Query("select new com.example.demo.dto.OrderInfoDto(o.id, o.order_no, o.order_date, tb.id,o.totalPrice,o.status) "
			+ "from Order o join o.table_id tb "
			+ "where o.order_date BETWEEN :stDate AND :edDate")
//	@Query(value = "select * from _order WHERE order_date BETWEEN :stDate AND :edDate", nativeQuery = true)
	public List<OrderInfoDto> listOrderInfoFromDateToDate(Date stDate,Date edDate);
}
