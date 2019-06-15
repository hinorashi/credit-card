package com.hino.credit_card.handler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.hino.credit_card.dto.ValidationErrorResDto;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {

    List<ValidationErrorResDto> errors = new ArrayList<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      ValidationErrorResDto fieldError =
          ValidationErrorResDto.builder()
          .field(((FieldError) error).getField())
          .message(error.getDefaultMessage())
          .build();
      errors.add(fieldError);
    });

    return ResponseEntity.badRequest().body(errors);
  }

}
