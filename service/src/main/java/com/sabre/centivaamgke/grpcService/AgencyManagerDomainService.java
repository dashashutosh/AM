package com.sabre.centivaamgke.grpcService;

import com.sabre.centiva.offer.gke.api.AgencyManager.OfferCommissionRQ;
import com.sabre.centiva.offer.gke.api.AgencyManager.OfferCommissionRS;
import com.sabre.centiva.offer.gke.api.AgencyManagerServiceGrpc;
import com.sabre.centivaamgke.controllers.SaleHandler;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@RequiredArgsConstructor
@GrpcService
public class AgencyManagerDomainService
    extends AgencyManagerServiceGrpc.AgencyManagerServiceImplBase {
  private final SaleHandler saleHandler;

  @Override
  public void processOfferCommission(
      OfferCommissionRQ request, StreamObserver<OfferCommissionRS> responseObserver) {
    log.info("Received request: {}", request.getStationNumber());
    saleHandler.handle();
    OfferCommissionRS response =
        OfferCommissionRS.newBuilder()
            .setTransactionId("97272")
            .setAccountNumber("27197727719727172727271")
            .build();

    responseObserver.onNext(response);
    log.info("Sent response: {}", response);
    responseObserver.onCompleted();
  }
}
