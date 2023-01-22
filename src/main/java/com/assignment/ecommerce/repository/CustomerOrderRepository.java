package com.assignment.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.ecommerce.model.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

}
