package com.sabre.centivaamgke.validators;

import com.sabre.centivaamgke.OAndDCommission;
import com.sabre.centivaamgke.TicketLevelCommission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChooseCommissionType {

  private final OAndDCommission oAndDCommission;
  private final TicketLevelCommission ticketLevelCommission;

  public ChooseCommissionType(
      OAndDCommission oAndDCommission, TicketLevelCommission ticketLevelCommission) {
    this.oAndDCommission = oAndDCommission;
    this.ticketLevelCommission = ticketLevelCommission;
  }

  public void commissionType() {
    log.info("Choose Commission Type");
    oAndDCommission.calculateCommission(oAndDCommission);
    ticketLevelCommission.calculateCommission(ticketLevelCommission);
  }
}
