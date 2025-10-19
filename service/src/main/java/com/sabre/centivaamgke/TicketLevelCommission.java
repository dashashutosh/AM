package com.sabre.centivaamgke;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TicketLevelCommission implements CommissionType {
  @Override
  public Object calculateCommission(Object o) {
    log.info("calculate TicketLevelCommission ");
    return null;
  }
}
