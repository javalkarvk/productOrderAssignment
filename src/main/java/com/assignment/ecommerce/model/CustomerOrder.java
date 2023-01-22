package com.assignment.ecommerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "email")
  private String email;
  
  @Column(name = "status")
  private String status;
  
  @Column(name = "created_by")
  private String cretaedBy;
  
  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "modified_by")
  private String modifiedBy;
  
  @Column(name = "modified_at")
  private Date modifiedAt;
  
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

  public String getCretaedBy() {
    return cretaedBy;
  }

  public void setCretaedBy(String cretaedBy) {
    this.cretaedBy = cretaedBy;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public List<OrderDetails> getOrderDetailsList() {
	return orderDetailsList;
  }

  public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
	this.orderDetailsList = orderDetailsList;
  }
}
