package com.assignment.ecommerce.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "product_audit")
public class ProductAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "product_id")
  private Long productId;
  
  @Column(name = "skuid")
  private String skuId;

  @Column(name = "product_name")
  private String productName;
  
  @Column(name = "status")
  private Character status;
  
  @Column(name = "price")
  private Integer price;

  @Column(name = "is_deleted")
  private boolean isDeleted;
  
  @Column(name = "action")
  private String action;

  @Column(name = "created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  public ProductAudit(Product product, String action) {
	setProductId(product.getId());
	setAction(action);
	setProductName(product.getProductName());
	setCreatedAt(new Date());
	setSkuId(product.getSkuId());
	setPrice(product.getPrice());
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String description) {
    this.skuId = description;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String title) {
    this.productName = title;
  }
  
  public Character getStatus() {
    return status;
  }

  public void setStatus(Character status) {
    this.status = status;
  }
  
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public boolean getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public Long getProductId() {
	return productId;
  }

  public void setProductId(Long productId) {
	this.productId = productId;
  }

  public String getAction() {
	return action;
  }

  public void setAction(String action) {
	this.action = action;
  }

  public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
  }
}
