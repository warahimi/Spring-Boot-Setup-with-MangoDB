package com.wahid.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.wahid.models.OrderEntity;

public interface OrdersRepositoryInterface extends MongoRepository<OrderEntity, String>{
	
	@Query("{'productName':{'$regex' : ?0, '$options':'i'}}")
	List<OrderEntity> findByProductName(String searchTerm);

}
