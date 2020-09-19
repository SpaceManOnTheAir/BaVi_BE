package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.BillDto;
import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select new com.example.demo.dto.BillDto(it.name,it.price,od.quantity,o.totalPrice) "
			+ "from Order o join o.orderDetails od join od.items it "
			+ "where o.id= :id"
			)
	public List<BillDto> getBill(Integer id);
}
