package com.assignment.ecommerce.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class Product {
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
}
