package com.assignment.ecommerce.exceptions;

public class ProductExceptions extends RuntimeException {
  private String msg;
  public ProductExceptions() {}
  public ProductExceptions(String msg) {
    super(msg);
    this.msg = msg;
  }
}
