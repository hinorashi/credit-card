package com.hino.credit_card.controller;

import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hino.credit_card.dto.CreditCardReqDto;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestValidationController {

  @PostMapping
  public ResponseEntity<?> validation(@Valid @RequestBody CreditCardReqDto reqDto) {
    return ResponseEntity.ok().build();
  }
}
