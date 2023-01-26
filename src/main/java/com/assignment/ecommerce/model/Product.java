package com.assignment.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class Product extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
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

  public Product() {}

  public Product(String productName, String skuId, boolean deleted) {
    this.productName = productName;
    this.skuId = skuId;
    this.isDeleted = deleted;
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

  public boolean getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }
}
