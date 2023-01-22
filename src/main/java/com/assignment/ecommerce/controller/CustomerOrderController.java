package com.assignment.ecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ecommerce.model.CustomerOrder;
import com.assignment.ecommerce.service.CustomerOrderService;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {
  
  @Autowired
  private CustomerOrderService service;
  
  @RequestMapping("/newOrder")
  public List<CustomerOrder> getString() {
    return service.getOrders();
  }

  @GetMapping("/list")
  public ResponseEntity<?> getProduct() {
    try {
    List<CustomerOrder> orders = service.getOrders();

    if (orders.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(orders, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/list/{id}")
  public Map<String, Object> getProduct(@PathVariable("id") long id) {
    return service.getOrder(id);
  }
}
