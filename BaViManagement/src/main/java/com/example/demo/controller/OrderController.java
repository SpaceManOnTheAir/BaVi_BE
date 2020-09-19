package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BillDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// CREATE AN ORDER
	@PostMapping(value = "")
	public Order createAnOrder(@RequestBody @Valid OrderDto orderDto, BindingResult result) {
		if (result.hasErrors())
			throw new IllegalArgumentException("Invalid Order data");
		return orderService.createAnOrder(orderDto);
	}

	// GET A LIST OF ORDER
	@GetMapping(value = "")
	public List<Order> listAll() {
		return orderService.listAll();
	}

	// GET AN ORDER
	@GetMapping(value = "/{id}")
	public Order getAnOrder(@PathVariable (value = "id")int id) {
		return orderService.getAnOrder(id);
	}

	// DELETE AN ORDER
	@DeleteMapping(value = "/{id}")
	public void deleteAnOrder(@PathVariable("id")Integer id) {
		orderService.deleteOrder(id);
	}
	
	
	@GetMapping(value = "/bill/{id}")
	public  List<BillDto> getBill(@PathVariable(value = "id") Integer id) {
		return orderService.getBill(id);
	}

}
