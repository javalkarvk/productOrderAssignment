package com.assignment.ecommerce.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_details")
@EntityListeners(AuditingEntityListener.class)
public class OrderDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "order_id")
  private long orderId;
  
  @Column(name = "product_id")
  private long productId;
  
  @Column(name = "qty")
  private int qty;
  
  @Column(name = "status")
  private Character status;

  @Column(name = "is_deleted")
  private boolean isDeleted;
  
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

  @ManyToOne
  @JoinColumn(name = "order_id", insertable = false, updatable = false)
  private CustomerOrder customerOrder;
  
  @ManyToOne
  @JoinColumn(name = "product_id", insertable = false, updatable = false)
  private Product product;
  
  public OrderDetails() {
    
  }
  
  public OrderDetails(int orderId, int productId, char status) {
    setOrderId(orderId);
    setProductId(productId);
    setStatus(status);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public Character getStatus() {
    return status;
  }

  public void setStatus(Character status) {
    this.status = status;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
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
  
  public String getModifiedBy() {
  	return modifiedBy;
  }
  
  public void setModifiedBy(String modifiedBy) {
  	this.modifiedBy = modifiedBy;
  }

  public Date getModifiedDate() {
  	return modifiedDate;
  }
  
  public void setModifiedDate(Date modifiedDate) {
  	this.modifiedDate = modifiedDate;
  }
  
  public CustomerOrder getCustomerOrder() {
	return customerOrder;
  }

  public void setCustomerOrder(CustomerOrder customerOrder) {
	this.customerOrder = customerOrder;
  }

  public Product getProduct() {
	return product;
  }

  public void setProduct(Product product) {
	this.product = product;
  }
}
