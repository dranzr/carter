package com.carter.product.services;

import com.carter.Command;
import com.carter.product.ProductRepository;
import com.carter.product.model.Product;
import com.carter.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

  private final ProductRepository productRepository;

  public CreateProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ResponseEntity<ProductDTO> execute(Product product) {
    //        ProductValidator.execute(product);
    Product savedProduct = productRepository.save(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
  }
}
