package com.carter.product.services;

import com.carter.Query;
import com.carter.exceptions.ProductNotFoundException;
import com.carter.product.ProductRepository;
import com.carter.product.model.Product;
import com.carter.product.model.ProductDTO;
import java.util.Optional;
import java.util.UUID;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetProductService implements Query<UUID, ProductDTO> {

  private final ProductRepository productRepository;

  public GetProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  @Cacheable("productCache")
  public ResponseEntity<ProductDTO> execute(UUID productId) {
    Optional<Product> productOptional = productRepository.findById(productId);
    if (productOptional.isPresent()) {
      return ResponseEntity.ok(new ProductDTO(productOptional.get()));
    }

    throw new ProductNotFoundException();
  }
}
