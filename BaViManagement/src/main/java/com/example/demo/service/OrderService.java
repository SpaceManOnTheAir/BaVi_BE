package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.MainCategoryController;
import com.example.demo.dao.ItemRepository;
import com.example.demo.dao.OrderDetailRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.TableRepository;
import com.example.demo.dto.BillDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderInfoDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Status;
import com.example.demo.entity.Table;
import com.example.demo.exception.ResourceExistException;
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
	

	public List<OrderInfoDto> listAll() {
		return orderRepo.listOrderInfo();
	}

	public OrderInfoDto getAnOrder(int id) {
		orderRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Order id"));
		return orderRepo.getOrderInfo(id);
	}
	
	// PAYMENT
	public Order payment(Integer id) {
		Order order =orderRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Order id"));
		if (order.getStatus() == Status.PAID)
			new ResourceExistException("order has already paid: " +order.getId());
		else order.setStatus(Status.PAID);
		
		return orderRepo.save(order);
		
	}

	public Order createAnOrder(OrderDto orderDto) {
		Table aTable = null;
		Integer tableID = orderDto.getTable_id();
		// CHECK EXISTING TABLE
		if (tableID == null)
			throw new IllegalArgumentException("Cannot find ID Table ");
		if (tableRepo.findById(tableID).isPresent())
			aTable = tableRepo.findById(tableID).get();
		
		Order anOrder = new Order(orderDto, aTable);
		

		// ORDER DETAILS
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
		// Update order_no
		anOrder.setOrder_no("ORD"+ anOrder.getId());
		orderRepo.save(anOrder);

		for (OrderDetail aDetail : listOrderDetails) {
			aDetail.setOrder_id(anOrder);
			// update detail again
			orderDetailRepo.save(aDetail);
		}
		return anOrder;
	}

	// UPDATE AN ORDER
	public Order update(OrderDto orderDto) {
		Order anOrder = orderRepo.findById(orderDto.getId())
				.orElseThrow(() -> new IllegalArgumentException("Cannot find the order id" + orderDto.getId()));
		List<OrderDetail> listOrderDetails = anOrder.getOrderDetails();

		Double totalPrice = 0.0;
		for (OrderDetail order : listOrderDetails) {
			for (int i = 0; i < orderDto.getItems().size(); i++) {
				if (orderDto.getItems().get(i).getId() == order.getId()) {
					order.setQuantity(orderDto.getItems().get(i).getQuantity());
					totalPrice += order.getPrice() * order.getQuantity();
					orderDetailRepo.save(order);
				}

			}
		}
		anOrder.setTotalPrice(totalPrice);
		orderRepo.save(anOrder);

		return anOrder;
	}

	public void deleteOrder(Integer id) {
		orderRepo.deleteById(id);
	}

	public List<BillDto> getBill(Integer id) {
		return orderRepo.getBill(id);
	}

	// Delete items in order list

	public void deleteABill(Integer orderId, Integer itemId) {
		getAnOrder(orderId);
//		orderDetailRepo.findById(itemId)
//				.orElseThrow(() -> new IllegalArgumentException("Cannot find this item id= " + itemId));

		// GET A BILLDTO LIST
		Order order = orderRepo.findById(orderId).get();
		List<OrderDetail> orderDetail = order.getOrderDetails();

		Double deleteTotal = 0.0;

		for (OrderDetail item : orderDetail) {
			System.out.println(item.getItems().getId());
			if (item.getId() == itemId) {
				deleteTotal = item.getPrice() * item.getQuantity();
				System.out.println(item.getPrice());
				orderDetail.remove(item);
				orderDetailRepo.deleteById(item.getId());
//					minusTotalPrice(orderId,deleteTotal);
//					Order update = orderRepo.findById(orderId).get();
//					update.setId(update.getId());
//					update.setOrderDetails(deleteBill);
//					//	 UPDATE TOTAL PRICE
//					update.setTotalPrice(update.getTotalPrice() - deleteTotal);
//					orderRepo.save(update);

				break;
			}
		}
//			Order update = orderRepo.findById(orderId).get();
//			update.setId(update.getId());
//			update.setOrderDetails(deleteBill);
//			//	 UPDATE TOTAL PRICE
//			update.setTotalPrice(update.getTotalPrice() - deleteTotal);
//			orderRepo.save(update);

		order.setOrderDetails(orderDetail);
		order.setTotalPrice(order.getTotalPrice() - deleteTotal);
		orderRepo.save(order);

	}

	public Order minusTotalPrice(Integer orderId, double newPrice) {
		Order updateOrder = orderRepo.findById(orderId).get();
		updateOrder.setTotalPrice(updateOrder.getTotalPrice() - newPrice);
		return orderRepo.save(updateOrder);
	}
	
	public  List<OrderInfoDto>  listOrderInfoFromDateToDate(Date fromDate, Date toDate){
		return orderRepo.listOrderInfoFromDateToDate(fromDate, toDate);
	}

}
