package com.assignment.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {
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
