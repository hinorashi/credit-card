package com.hino.credit_card.dto;

import com.hino.credit_card.validator.CreditCardValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardReqDto {

  @CreditCardValid
  String creditCardNumber;
}
