package com.carter.product.services;

import com.carter.Command;
import com.carter.exceptions.ProductNotFoundException;
import com.carter.product.ProductRepository;
import com.carter.product.model.Product;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService implements Command<UUID, Void> {

  private final ProductRepository productRepository;

  public DeleteProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ResponseEntity<Void> execute(UUID id) {
    Optional<Product> productOptional = productRepository.findById(id);
    if (productOptional.isPresent()) {
      productRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    throw new ProductNotFoundException();
  }
}
