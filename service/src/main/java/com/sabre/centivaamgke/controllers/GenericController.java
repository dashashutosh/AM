package com.sabre.centivaamgke.controllers;

import com.sabre.security.ctm.AuditLogEntry;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import java.util.Arrays;
import java.util.Collections;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class GenericController {

  private static final Logger auditLog = LoggerFactory.getLogger(GenericController.class);
  private final MeterRegistry meterRegistry;

  public GenericController(MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
  }

  @RequestMapping("/hello")
  public ResponseEntity<String> hello() {
    return ResponseEntity.ok("Hello Anonymous!");
  }

  @RequestMapping("/hello/{name}")
  public ResponseEntity<String> hello(@PathVariable String name) {

    /*
    For PCI application auditLog is mandatory
    more examples for auditLog you will find here:
    https://gitdocs.sabre.com/gitdocs/ngp-starters/how-to-guides/logging-starter-application-audit.html
    */

    AuditLogEntry auditLogEntryBuilderExample1 =
        new AuditLogEntry("RSE:AUDIT-EXAMPLE", "log-builder-structured")
            .withOperationStatus("SUCCESS")
            .withUserId(name)
            .withResourceType("PNR")
            .withResourceId("123456-AAS-AA")
            .withCallerId("CAM:SLAP-GCP")
            .withSourceAddress("1.2.3.4")
            .withDestinationAddress("https://webservices.platform.sabre.com/websvc")
            .withRawData(
                Collections.singletonMap(
                    "x-forwarded-for", "203.0.113.195, 70.41.3.18, 150.172.238.178"));

    auditLog.info(
        "Application Audit Log entry operation {}",
        "abc",
        StructuredArguments.value("auditLog", auditLogEntryBuilderExample1.toMap()));

    if ("NGP".equalsIgnoreCase(name)) {
      // Example of custom business metrics. Spring metrics are available by default.
      meterRegistry
          .counter(
              "number.of.request.calls",
              Arrays.asList(Tag.of("uri", "/hello/{name}"), Tag.of("name", "NGP")))
          .increment();
    }

    String message = String.format("Hello %s!", HtmlUtils.htmlEscape(name));
    return ResponseEntity.ok(HtmlUtils.htmlEscape(message));
  }
}
