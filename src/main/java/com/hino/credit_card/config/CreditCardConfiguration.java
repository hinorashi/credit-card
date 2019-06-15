package com.hino.credit_card.config;

import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class CreditCardConfiguration {

  @Autowired
  MessageSource messageSource;

  // let the auto configuration kick in
  // @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:messages");
    messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
    messageSource.setCacheSeconds(5);
    return messageSource;
  }

  @Bean
  public LocalValidatorFactoryBean getValidator() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    log.info("MessageSource in use: {}", messageSource);
    bean.setValidationMessageSource(messageSource);
    return bean;
  }
}
