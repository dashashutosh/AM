package com.sabre.centivaamgke.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericRootControllerTest {
  GenericRootController genericRootController = new GenericRootController("APP");

  @Test
  public void shouldReturnWelcomeMessageWhenRootEndpointCalled() {
    // when
    ResponseEntity<String> response = genericRootController.root();

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("This is auto-generated 'APP' application env 'null'");
  }
}
