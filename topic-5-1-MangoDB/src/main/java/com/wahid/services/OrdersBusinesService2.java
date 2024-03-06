package com.wahid.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.wahid.data.OrdersDataAccessInterface;
import com.wahid.models.OrderModel;

@Service
@Primary
public class OrdersBusinesService2 implements OrdersBusinessServiceInterface {
	
	@Autowired
	OrdersDataAccessInterface<OrderModel> ordersDAO;
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Orders Business Service Class is Working..");
		
	}

	@Override
	public List<OrderModel> getOrders() {

		return ordersDAO.getOrders();
	}

	@Override
	public OrderModel getById(String id) {
		return ordersDAO.getById(id);
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		return ordersDAO.searchOrders(searchTerm);
	}

	@Override
	public String addOne(OrderModel newOrder) {
		
		return ordersDAO.addOne(newOrder);
	}

	@Override
	public boolean deleteOne(String id) {
		return ordersDAO.deleteOne(id);
	}

	@Override
	public OrderModel updateOne(String id, OrderModel updateOrder) {
		
		return ordersDAO.updateOne(id, updateOrder);
	}

}
