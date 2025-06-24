package com.carter.product.model;

import java.util.UUID;

public class CustomerDTO {
  private UUID id;
  private String firstName;
  private String lastName;

  // Constructors
  public CustomerDTO() {}

  public CustomerDTO(UUID id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Getters and Setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  // toString Method
  @Override
  public String toString() {
    return "CustomerDTO{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
  }
}
