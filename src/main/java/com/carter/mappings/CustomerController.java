package com.carter.mappings;

import com.carter.exceptions.ResourceNotFoundException;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

  private final CustomerRepository customerRepository;

  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id) {
    Customer customer =
        customerRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    return ResponseEntity.ok(customer);
  }
}
