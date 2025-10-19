package com.sabre.centivaamgke.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericControllerTest {
  GenericController genericController = new GenericController(mock(MeterRegistry.class));

  @Test
  public void shouldReturnMessageForAnonymousCall() {
    // when
    ResponseEntity<String> response = genericController.hello();

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Hello Anonymous!");
  }

  @Test
  public void shouldReturnMessageForName() {
    // when
    ResponseEntity<String> response = genericController.hello("Sabre");

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Hello Sabre!");
  }
}
