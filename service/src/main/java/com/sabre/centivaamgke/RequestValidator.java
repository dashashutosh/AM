package com.sabre.centivaamgke;

public interface RequestValidator<K, R> {

  R validate(K k);
}
