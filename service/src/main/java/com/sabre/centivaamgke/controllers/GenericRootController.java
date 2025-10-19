package com.sabre.centivaamgke.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericRootController {
  private String applicationName;

  @Value("${app.env:none}")
  private String env;

  public GenericRootController(@Value("${spring.application.name}") String applicationName) {
    this.applicationName = applicationName;
  }

  @RequestMapping("/")
  public ResponseEntity<String> root() {
    String message =
        String.format("This is auto-generated '%s' application env '%s'", applicationName, env);
    return ResponseEntity.ok(message);
  }
}
