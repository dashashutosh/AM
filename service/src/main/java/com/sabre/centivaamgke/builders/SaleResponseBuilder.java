package com.sabre.centivaamgke.builders;

import com.sabre.centivaamgke.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaleResponseBuilder implements ResponseBuilder {

  @Override
  public Object build(Object o) {
    log.info("Building Sale Response");
    return null;
  }
}
