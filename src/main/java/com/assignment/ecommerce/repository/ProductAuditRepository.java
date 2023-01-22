package com.assignment.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.ecommerce.model.ProductAudit;

public interface ProductAuditRepository extends JpaRepository<ProductAudit, Long> {

}
