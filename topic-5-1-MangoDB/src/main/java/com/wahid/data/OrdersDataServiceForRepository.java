package com.wahid.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.wahid.models.OrderEntity;
import com.wahid.models.OrderModel;

@Repository
@Primary
public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderModel>{

	@Autowired
	OrdersRepositoryInterface ordersRepository;	
	

	
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public OrderModel getById(String id) {
		OrderEntity orderEntity = ordersRepository.findById(id).orElse(null); // if not found return null 
		//Optional<OrderEntity> orderEntity = ordersRepository.findById(id); // if not found return null 
		
//		OrderModel orderModel = new OrderModel(orderEntity.getId(),
//				orderEntity.getOrderNo(),
//				orderEntity.getProductName(), 
//				orderEntity.getPrice(),
//				orderEntity.getQuantity());
//		return orderModel;
		OrderModel orderModel = modelMapper.map(orderEntity, OrderModel.class);
		return orderModel;
	}

	@Override
	public List<OrderModel> getOrders() {
		Iterable<OrderEntity>  Orderentities = ordersRepository.findAll();
		List<OrderModel> orderModels = new ArrayList<>();
		
		for(OrderEntity orderEntity : Orderentities)
		{
			orderModels.add(modelMapper.map(orderEntity, OrderModel.class));
		}
		return orderModels;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		Iterable<OrderEntity> entities = ordersRepository.findByProductName(searchTerm);
		List<OrderModel> orderModels = new ArrayList<>();
		for(OrderEntity item : entities)
		{
			orderModels.add(modelMapper.map(item, OrderModel.class));
		}
		return orderModels;
	}

	@Override
	public String addOne(OrderModel newOrder) {
		
		OrderEntity entity = modelMapper.map(newOrder, OrderEntity.class);
		OrderEntity res = ordersRepository.save(entity);
		return res != null ? res.getId(): "";
	}

	@Override
	public boolean deleteOne(String id) {
		ordersRepository.deleteById(id);
		return true;
	}

	@Override
	public OrderModel updateOne(String id, OrderModel updateOrder) {
		OrderEntity entity = modelMapper.map(updateOrder, OrderEntity.class);
		OrderEntity result = ordersRepository.save(entity);
		return modelMapper.map(result, OrderModel.class);
	}

}
