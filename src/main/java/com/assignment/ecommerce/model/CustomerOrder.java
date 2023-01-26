package com.assignment.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customer_order")
@EntityListeners(AuditingEntityListener.class)
public class CustomerOrder extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column(name = "email")
  private String email;
  
  @Column(name = "status")
  private String status;
  
  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<OrderDetails> orderDetailsList;
  
  public CustomerOrder() {}
  
  public CustomerOrder(String email, String status) {
    setEmail(email);
    setStatus(status);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<OrderDetails> getOrderDetailsList() {
	return orderDetailsList;
  }

  public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
	this.orderDetailsList = orderDetailsList;
  }
}
