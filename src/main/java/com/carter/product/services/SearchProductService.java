package com.carter.product.services;

import com.carter.Query;
import com.carter.product.ProductRepository;
import com.carter.product.model.ProductDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {
  private final ProductRepository productRepository;

  public SearchProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ResponseEntity<List<ProductDTO>> execute(String name) {
    return ResponseEntity.ok(
        productRepository.findByNameOrDescriptionContaining(name).stream()
            .map(ProductDTO::new)
            .toList());
  }
}
