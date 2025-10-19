package com.sabre.centivaamgke;

public interface ResponseBuilder<K, R> {

  R build(K k);
}
