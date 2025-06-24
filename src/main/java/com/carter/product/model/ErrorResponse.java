package com.carter.product.model;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

public abstract class ErrorResponse {
  private String message;

  public ErrorResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public abstract HttpStatusCode getStatusCode();

  public abstract ProblemDetail getBody();
}
