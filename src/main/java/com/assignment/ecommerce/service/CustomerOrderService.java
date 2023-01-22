package com.assignment.ecommerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.ecommerce.model.CustomerOrder;
import com.assignment.ecommerce.model.OrderDetails;
import com.assignment.ecommerce.repository.CustomerOrderRepository;

@Service
public class CustomerOrderService {
  
  @Autowired
  private CustomerOrderRepository repository;
  
  public List<CustomerOrder> getOrders() {
    return repository.findAll();
  }
  
  public Map<String, Object> getOrder(long id) {
	Optional<CustomerOrder> orderData = repository.findById(Long.valueOf(1));
	if (!orderData.isPresent()) {
	  return null;
	}
	CustomerOrder order = orderData.get();
	Map<String, Object> orderMap = new HashMap<>();
	orderMap.put("order_no", order.getId());
	orderMap.put("email_id", order.getEmail());
	orderMap.put("order_date", order.getCreatedAt());
	orderMap.put("status", order.getStatus());
	List<OrderDetails> orderDetails = order.getOrderDetailsList();
	List<Map<String, Object>> productsOrdered = new ArrayList<>();
	Map<String, Object> productDetails;
	for (OrderDetails item : orderDetails) {
	  productDetails = new HashMap<>();
	  productDetails.put("product_name", item.getProduct().getProductName());
	  productDetails.put("quantity", item.getQty());
	  productDetails.put("price", item.getProduct().getPrice());
	  productDetails.put("status", item.getStatus());
	  productsOrdered.add(productDetails);
	}
	orderMap.put("product_list", productsOrdered);
	return orderMap;
  }
}
