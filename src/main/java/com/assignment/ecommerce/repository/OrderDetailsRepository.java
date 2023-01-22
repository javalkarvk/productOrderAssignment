package com.assignment.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.ecommerce.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
