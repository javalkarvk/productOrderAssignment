package com.assignment.ecommerce.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "product")
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
  
  @Column(name = "created_by")
  private String createdBy;
  
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

  public Product() {

  }

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

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String cretaedBy) {
    this.createdBy = cretaedBy;
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

  public boolean getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }
}
