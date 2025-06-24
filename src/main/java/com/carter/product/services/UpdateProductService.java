package com.carter.product.services;

import com.carter.Command;
import com.carter.exceptions.ProductNotFoundException;
import com.carter.product.ProductRepository;
import com.carter.product.model.Product;
import com.carter.product.model.ProductDTO;
import com.carter.product.model.UpdateProductCommand;
import com.carter.product.validator.ProductValidator;
import java.util.Optional;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

  private final ProductRepository productRepository;

  public UpdateProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  @CachePut(value = "productCache", key = "#command.getId()")
  public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
    // Safely retrieve the product from the repository
    Optional<Product> productOptional = productRepository.findById(command.getId());

    // Check if the product is present and update it
    if (productOptional.isPresent()) {
      Product product = command.getProduct();
      product.setId(command.getId()); // Update product with the command's id

      // Validate product using the ProductValidator
      ProductValidator.execute(product);

      // Save the updated product to the repository
      productRepository.save(product);

      // Return the updated product as a ProductDTO
      return ResponseEntity.ok(
          new ProductDTO(product)); // Ensure ProductDTO constructor works with Product
    } else {
      // Throw an exception if the product is not found
      throw new ProductNotFoundException("Product not found");
    }
  }
}
