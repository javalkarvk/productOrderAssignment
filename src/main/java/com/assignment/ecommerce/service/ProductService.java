package com.assignment.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.assignment.ecommerce.exceptions.ProductExceptions;
import com.assignment.ecommerce.model.Product;
import com.assignment.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;
  
  public Product createProduct(Product pro) {
    Product newProduct = new Product();
    newProduct.setProductName(pro.getProductName());
    if(StringUtils.hasLength(pro.getSkuId()) && null != repository.findBySkuId(pro.getSkuId())) {
          throw new ProductExceptions("Product with skuid - "+pro.getSkuId()+" already exists.");
    }
    newProduct.setSkuId(pro.getSkuId());
    newProduct.setPrice(pro.getPrice());
    repository.save(newProduct);
    return newProduct;
  }
  
  public Product updateProduct(Long id, Product pro) {
    Product product = repository.findById(id).orElse(null);
    if (null != product) {
      product.setProductName(pro.getProductName());
      product.setPrice(pro.getPrice());
      repository.save(product);
      return product;
    }
    return product;
  }
  
  public List<Product> findProduct(String productName) {
    List<Product> products = new ArrayList<Product>();

    if (!StringUtils.hasLength(productName)) {
      repository.findAll().forEach(products::add);
    } else {
    repository.findByProductNameContaining(productName).forEach(products::add);
    }
    return products;
  }
  
  public Optional<Product> findProduct(long id) {
    return repository.findById(id);
  }
  
  public Product deleteProduct(long id) {
    Product product = repository.findById(id).orElse(null);
    if (null != product) {
      product.setIsDeleted(true);
      repository.save(product);
      return product;
    }
    return product;
  }
}
