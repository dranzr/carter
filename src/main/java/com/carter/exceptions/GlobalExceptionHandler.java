package com.carter.exceptions;

import com.carter.product.model.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleProductNotFoundException(ProductNotFoundException exception) {
    return new ErrorResponse(exception.getMessage()) {
      @Override
      public HttpStatusCode getStatusCode() {
        return null;
      }

      @Override
      public ProblemDetail getBody() {
        return null;
      }
    };
  }

  @ExceptionHandler(ProductNotValidException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleProductNotValidException(ProductNotValidException exception) {
    return new ErrorResponse(exception.getMessage()) {
      @Override
      public HttpStatusCode getStatusCode() {
        return null;
      }

      @Override
      public ProblemDetail getBody() {
        return null;
      }
    };
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleProductNotValidConstraints(ConstraintViolationException exception) {
    return new ErrorResponse(exception.getConstraintViolations().iterator().next().getMessage()) {
      @Override
      public HttpStatusCode getStatusCode() {
        return null;
      }

      @Override
      public ProblemDetail getBody() {
        return null;
      }
    };
  }
}
