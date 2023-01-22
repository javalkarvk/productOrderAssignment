package com.assignment.ecommerce.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
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
  
  @Column(name = "created_by")
  private String cretaedBy;
  
  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "modified_by")
  private String modifiedBy;
  
  @Column(name = "modified_at")
  private Date modifiedAt;
  
  @Column(name = "deleted_by")
  private String deletedBy;
  
  @Column(name = "deleted_at")
  private Date deletedAt;

  @Column(name = "is_deleted")
  private boolean isDeleted;
  
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

  public String getDeletedBy() {
    return deletedBy;
  }

  public void setDeletedBy(String deletedBy) {
    this.deletedBy = deletedBy;
  }

  public Date getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
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
