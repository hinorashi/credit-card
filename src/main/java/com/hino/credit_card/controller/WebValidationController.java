package com.hino.credit_card.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.hino.credit_card.dto.CreditCardReqDto;

@Controller
@RequestMapping
public class WebValidationController {

  @GetMapping
  public String form(CreditCardReqDto reqDto) {
    return "form";
  }

  @PostMapping
  public String validate(@Valid CreditCardReqDto reqDto, BindingResult result, RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
      return "form";
    }

    redirectAttributes.addFlashAttribute("message", "Your credit card is valid!");
    return "redirect:/";
  }
}
