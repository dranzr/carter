package com.carter.product.model;

import java.util.UUID;

public class UpdateProductCommand {
  private UUID id;
  private Product product;

  public UpdateProductCommand(UUID id, Product product) {
    this.id = id;
    this.product = product;
  }

  public UUID getId() {
    return id;
  }

  public Product getProduct() {
    return product;
  }
}
