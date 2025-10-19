package com.sabre.centivaamgke.validators;

import com.sabre.centivaamgke.Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaleProcessor implements Processor {

  @Override
  public Object process(Object o) {
    log.info("Sale Data Processing");
    return null;
  }
}
