package com.assignment.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByIsDeleted(boolean isDeleted);

  List<Product> findByProductNameContaining(String productName);
  
  Product findBySkuId(String skuId);
  
  @Override
  @Query("SELECT p FROM Product p WHERE p.isDeleted IS FALSE")
  List<Product> findAll();
}