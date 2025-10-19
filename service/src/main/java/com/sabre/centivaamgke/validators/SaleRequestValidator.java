package com.sabre.centivaamgke.validators;

import com.sabre.centivaamgke.RequestValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaleRequestValidator implements RequestValidator {

  @Override
  public Object validate(Object o) {
    log.info("SaleRequestValidator execute");
    return null;
  }
}
