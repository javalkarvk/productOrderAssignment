package com.assignment.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ecommerce.model.Product;
import com.assignment.ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService service;

  @PostMapping("/create")
  public ResponseEntity<?> createProduct(@RequestBody Product product) {
    try {
      return new ResponseEntity<>(service.createProduct(product), HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
  
  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
    Product updatedProduct = service.updateProduct(id, product);

    if (null != updatedProduct) {
    return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    } else {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Requested product not found : "+id);
    }
  }
  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
    Product product = service.deleteProduct(id);
    if (null == product) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requested product not found : "+id);
    } else {
      return ResponseEntity.status(HttpStatus.OK).body("Requested product is deleted : "+id);
    }
  }
  
  @GetMapping("/list")
  public ResponseEntity<?> getProduct(@RequestParam(required = false) String product_name) {
    try {
    List<Product> products = service.findProduct(product_name);

    if (products.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(products, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/list/{id}")
  public ResponseEntity<?> getProduct(@PathVariable("id") long id) {
    Optional<Product> productData = service.findProduct(id);

    if (productData.isPresent()) {
      return new ResponseEntity<>(productData.get(), HttpStatus.OK);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requested product not found : "+id);
    }
  }
}
