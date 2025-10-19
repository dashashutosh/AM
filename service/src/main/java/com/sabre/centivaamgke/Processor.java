package com.sabre.centivaamgke;

public interface Processor<K, R> {

  R process(K k);
}
