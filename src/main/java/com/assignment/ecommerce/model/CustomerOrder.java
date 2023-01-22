package com.assignment.ecommerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customer_order")
@EntityListeners(AuditingEntityListener.class)
public class CustomerOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "email")
  private String email;
  
  @Column(name = "status")
  private String status;
  
  @CreatedBy
  @Column(name = "created_by")
  private String createdBy;

  @CreatedDate
  @Column(name = "created_date")
  private Date createdDate;

  @LastModifiedBy
  @Column(name = "modified_by")
  private String modifiedBy;

  @LastModifiedDate
  @Column(name = "modified_date")
  private Date modifiedDate;
  
  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<OrderDetails> orderDetailsList;
  
  public CustomerOrder() {
    
  }
  
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

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }
  
  

  public String getCreatedBy() {
	return createdBy;
  }

  public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
  }

  public Date getCreatedDate() {
	return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
  }

  public Date getModifiedDate() {
	return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
	this.modifiedDate = modifiedDate;
  }

  public List<OrderDetails> getOrderDetailsList() {
	return orderDetailsList;
  }

  public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
	this.orderDetailsList = orderDetailsList;
  }
}
