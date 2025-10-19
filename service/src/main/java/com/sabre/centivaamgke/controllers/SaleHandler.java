package com.sabre.centivaamgke.controllers;

import com.sabre.centivaamgke.builders.SaleResponseBuilder;
import com.sabre.centivaamgke.validators.ChooseCommissionType;
import com.sabre.centivaamgke.validators.SaleDocumentValidator;
import com.sabre.centivaamgke.validators.SaleProcessor;
import com.sabre.centivaamgke.validators.SaleRequestValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaleHandler {
  private final SaleRequestValidator saleRequestValidator;
  private final SaleProcessor saleProcessor;
  private final SaleDocumentValidator saleDocumentValidator;
  private final ChooseCommissionType chooseCommissionType;
  private final SaleResponseBuilder saleResponseBuilder;

  public void handle() {
    log.info("SaleHandler handle");
    saleRequestValidator.validate(null);
    saleProcessor.process(null);
    saleDocumentValidator.validate();
    chooseCommissionType.commissionType();
    saleResponseBuilder.build(null);
  }
}
