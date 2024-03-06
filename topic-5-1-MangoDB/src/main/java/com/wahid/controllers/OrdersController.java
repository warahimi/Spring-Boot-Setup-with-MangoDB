package com.wahid.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wahid.models.OrderModel;
import com.wahid.services.OrdersBusinessServiceInterface;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	//@Autowired
	OrdersBusinessServiceInterface service;
	
	
	
	public OrdersController(OrdersBusinessServiceInterface service) {
		super();
		this.service = service;
	}



	@GetMapping("/")
	public String showAllOrderString(Model model)
	{

		List<OrderModel> orders = service.getOrders();
		model.addAttribute("title", "These are what I plan to do this summer");
		model.addAttribute("orders", orders);
		return "orders.html";
	}
}
