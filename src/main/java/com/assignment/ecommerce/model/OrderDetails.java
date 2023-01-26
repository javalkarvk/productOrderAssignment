package com.assignment.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_details")
@EntityListeners(AuditingEntityListener.class)
public class OrderDetails extends Auditable<String> {
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

  @ManyToOne
  @JoinColumn(name = "order_id", insertable = false, updatable = false)
  private CustomerOrder customerOrder;
  
  @ManyToOne
  @JoinColumn(name = "product_id", insertable = false, updatable = false)
  private Product product;
  
  public OrderDetails() {}
  
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
