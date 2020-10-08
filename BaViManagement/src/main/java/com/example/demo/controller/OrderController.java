package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BillDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderInfoDto;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(MainCategoryController.class);
	@Autowired
	private OrderService orderService;

	// CREATE AN ORDER
	@PostMapping(value = "")
	public Order createAnOrder(@RequestBody @Valid OrderDto orderDto, BindingResult result) {
		if (result.hasErrors())
			throw new IllegalArgumentException("Invalid Order data");
		logger.info("create an order at table id " + orderDto.getTable_id());
		return orderService.createAnOrder(orderDto);
	}

	// UPDATE ORDER
	@PutMapping(value = "")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Order update(@RequestBody OrderDto orderDto) {
		logger.info("Update an order with id " + orderDto.getId());
		return orderService.update(orderDto);
	}

	// GET A LIST OF ORDER
	@GetMapping(value = "")
	public List<OrderInfoDto> listAll() {
		logger.info("List all Order Info");
		return orderService.listAll();
	}

	// GET AN ORDER
	@GetMapping(value = "/{id}")
	public OrderInfoDto getAnOrder(@PathVariable(value = "id") int id) {
		logger.info("Get an order with id "+ id);
		return orderService.getAnOrder(id);
	}

	// DELETE AN ORDER
	@DeleteMapping(value = "/{id}")
	public void deleteAnOrder(@PathVariable("id") Integer id) {
		logger.info("Delete an order with id" + id);
		orderService.deleteOrder(id);
	}

	// GET BILL BY ORDER ID
	@GetMapping(value = "/bill/{id}")
	public List<BillDto> getBill(@PathVariable(value = "id") Integer id) {
		logger.info("get an Bill by order id " + id);
		return orderService.getBill(id);
	}

	// DELETE BILL IN ORDER
	@DeleteMapping(value = "/{orderID}/{itemID}")
	public void deteteAnItemInOrder(@PathVariable(value = "orderID") Integer orderId,
			@PathVariable(value = "itemID") Integer itemID) {
		logger.info("Delete a bill in order id" + orderId);
		orderService.deleteABill(orderId, itemID);
	}

	// FILTER FROM DATE TO DATE
	@GetMapping("/search")
	public List<OrderInfoDto> listOrderInfoFromDateToDate(
			@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
		logger.info("Filter date from " + fromDate + " to "+ toDate);
		return orderService.listOrderInfoFromDateToDate(fromDate, toDate);
	}

	// PAYMENT
	@GetMapping("/payment/{orderID}")
	public Order payment(@PathVariable(value = "orderID") Integer orderId) {
		logger.info("Payment process with id " + orderId);
		return orderService.payment(orderId);
	}

}
