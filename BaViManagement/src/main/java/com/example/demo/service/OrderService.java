package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemRepository;
import com.example.demo.dao.OrderDetailRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.TableRepository;
import com.example.demo.dto.BillDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Table;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private TableRepository tableRepo;

	@Autowired
	private OrderDetailRepository orderDetailRepo;

	@Autowired
	private ItemRepository itemRepo;

	public List<Order> listAll() {
		return orderRepo.findAll();
	}

	public Order getAnOrder(int id) {
		return orderRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Order id"));
	}

	public Order createAnOrder(OrderDto orderDto) {
		Table aTable = null;
		Integer tableID = orderDto.getTable_id();
		if (tableID == null)
			throw new IllegalArgumentException("Cannot find ID Table ");
		if (tableRepo.findById(tableID).isPresent())
			aTable = tableRepo.findById(tableID).get();

		Order anOrder = new Order(orderDto, aTable);
		
		
		List<OrderDetail> listOrderDetails = new ArrayList<>();
		Double totalPrice = 0.0;
		for (int i = 0; i < orderDto.getItems().size(); i++) {

			OrderDetail orderDetail = new OrderDetail();

			orderDetail.setItems(itemRepo.findById(orderDto.getItems().get(i).getId()).get());
			orderDetail.setQuantity(orderDto.getItems().get(i).getQuantity());
			orderDetail.setPrice(itemRepo.findById(orderDto.getItems().get(i).getId()).get().getPrice());

			listOrderDetails.add(orderDetailRepo.save(orderDetail));
			totalPrice += orderDetail.getPrice() * orderDetail.getQuantity();

		}
		anOrder.setOrderDetails(listOrderDetails);
		anOrder.setTotalPrice(totalPrice);

		orderRepo.save(anOrder);
		for (OrderDetail aDetail : listOrderDetails) {
			aDetail.setOrder_id(anOrder);
			// update detail again
			orderDetailRepo.save(aDetail);
		}
		return anOrder;

	}

	public void deleteOrder(Integer id) {
		orderRepo.deleteById(id);
	}

	public List<BillDto> getBill(Integer id) {
		return orderRepo.getBill(id);
	}
}
