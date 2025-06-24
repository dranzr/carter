package com.carter.product.services;

import com.carter.Query;
import com.carter.product.ProductRepository;
import com.carter.product.model.Product;
import com.carter.product.model.ProductDTO;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetProductsService implements Query<Void, List<ProductDTO>> {

  private final ProductRepository productRepository;

  public GetProductsService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ResponseEntity<List<ProductDTO>> execute(Void input) {
    List<Product> products = productRepository.findAll();
    List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();

    return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
  }
}
