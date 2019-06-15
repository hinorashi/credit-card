package com.hino.credit_card.validator;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreditCardValidator implements ConstraintValidator<CreditCardValid, String> {

  // 16 digit, starts and ends with digit 3
  private static final String CREDIT_CARD_NUMBER_PATTERN = "^3\\d{14}3$";

  private final Pattern pattern = Pattern.compile(CREDIT_CARD_NUMBER_PATTERN);

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if (value == null)
      return false;

    return pattern.matcher(value).matches();
  }

}
