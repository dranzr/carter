package com.carter.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @UuidGenerator(style = UuidGenerator.Style.RANDOM)
  private UUID id;

  @NotNull(message = "Name is required")
  @Column(name = "name")
  private String name;

  @Column(name = "manufacturer")
  private String manufacturer;

  @Size(min = 20, message = "Description must be 20 characters long")
  @Column(name = "description")
  private String description;

  @PositiveOrZero(message = "Price must not be negative")
  @Column(name = "price")
  private Double price;

  public Product(UUID id, String name, String description, Double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Product() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
}
