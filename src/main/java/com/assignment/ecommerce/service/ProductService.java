package com.assignment.ecommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.assignment.ecommerce.exceptions.ProductExceptions;
import com.assignment.ecommerce.model.Product;
import com.assignment.ecommerce.model.ProductAudit;
import com.assignment.ecommerce.repository.ProductAuditRepository;
import com.assignment.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;
  
  @Autowired
  private ProductAuditRepository auditRepo;
  
  public Product createProduct(Product pro) {
    Product newProduct = new Product();
    newProduct.setProductName(pro.getProductName());
    if(StringUtils.hasLength(pro.getSkuId()) && null != repository.findBySkuId(pro.getSkuId())) {
          throw new ProductExceptions("Product with skuid - "+pro.getSkuId()+" already exists.");
    }
    newProduct.setSkuId(pro.getSkuId());
    newProduct.setPrice(pro.getPrice());
    newProduct.setCreatedBy("_api");
    newProduct.setCreatedAt(new Date());
    repository.save(newProduct);
    auditRepo.save(new ProductAudit(newProduct, "CREATE"));
    return newProduct;
  }
  
  public Product updateProduct(Long id, Product pro) {
    Product product = repository.findById(id).orElse(null);
    if (null != product) {
      product.setProductName(pro.getProductName());
      product.setPrice(pro.getPrice());
      product.setModifiedBy("_api");
      product.setModifiedAt(new Date());
      repository.save(product);
      auditRepo.save(new ProductAudit(product, "UPDATE"));
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
      product.setDeletedBy("_api");
      product.setDeletedAt(new Date());
      product.setIsDeleted(true);
      repository.save(product);
      auditRepo.save(new ProductAudit(product, "DELETE"));
      return product;
    }
    return product;
  }
}
