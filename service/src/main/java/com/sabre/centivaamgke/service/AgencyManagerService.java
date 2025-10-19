package com.sabre.centivaamgke.service;

import com.sabre.centiva.offer.gke.api.AgencyManager;
import com.sabre.centiva.offer.gke.api.AgencyManager.OfferCommissionRQ;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class AgencyManagerService {

  private static final Logger logger = LoggerFactory.getLogger(AgencyManagerService.class);

  public void processAgencyManager(final OfferCommissionRQ agencyManagerRequest) {
    logger.info("AgencyManager processing started");
    log.info("Received request: {}", agencyManagerRequest.getStationNumber());

    AgencyManager.OfferCommissionRS response =
        AgencyManager.OfferCommissionRS.newBuilder()
            .setTransactionId("97272")
            .setTransactionId("97272")
            .setAccountNumber("27197727719727172727271")
            .build();
    log.info("Sent response: {}", response);
  }
}
