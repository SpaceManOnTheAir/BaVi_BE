package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDetailRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.TableRepository;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Table;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepo;
	
//	@Autowired
//	private TableRepository tableRepo;
//
//	public List<OrderDetail> listAll() {
//		return orderDetailRepo.findAll();
//	}
//
//	public OrderDetail getAnOrder(int id) {
//		return orderDetailRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Order Detail id"));
//	}
//
//	public Order createAnOrder(OrderDto orderDto) {
//		Table aTable = null;
//		Integer tableID = orderDto.getTable_id();
//		if (tableID != null) {
//			if(tableRepo.findById(tableID).isPresent())
//				aTable=tableRepo.findById(tableID).get();
//		} else {
//			throw new IllegalArgumentException("Cannot find ID Table ");
//		}
//		
//		Order anOrder = new Order(orderDto, aTable);
//		return orderDetailRepo.save(anOrder);
//	}
//
//	public void deleteOrder(Integer id) {
//		orderDetailRepo.deleteById(id);
//	}
}
