package com.wahid.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wahid.models.OrderModel;
import com.wahid.services.OrdersBusinessServiceInterface;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersRESTControllers {
		//@Autowired
		OrdersBusinessServiceInterface service;
		
		public OrdersRESTControllers(OrdersBusinessServiceInterface service) {
			super();
			this.service = service;
		}

		@GetMapping("/")
		public List<OrderModel> showAllOrderString()
		{
			List<OrderModel> orders = service.getOrders();	
			return orders;
		}
		
		@GetMapping("/search/{searchTerm}")
		public List<OrderModel> searcOrders(@PathVariable(name="searchTerm") String srchTrm)
		{
			List<OrderModel> orders = service.searchOrders(srchTrm);	
			return orders;
		}
		
		@PostMapping("/")
		public String addOrder(@RequestBody OrderModel orderModel)
		{
			return service.addOne(orderModel);
		}
		
		@GetMapping("/{id}")
		public OrderModel getById(@PathVariable(name="id") String id)
		{
			return service.getById(id);
		}
		@DeleteMapping("/{id}")
		public boolean deletedById(@PathVariable(name="id") String id)
		{
			return service.deleteOne(id);
		}
		
		@PutMapping("/update/{id}")
		public OrderModel updateModel(@PathVariable(name="id") String id,
				@RequestBody OrderModel orderModel)
		{
			return service.updateOne(id, orderModel);
		}
}
