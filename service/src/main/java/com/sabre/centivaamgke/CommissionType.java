package com.sabre.centivaamgke;

public interface CommissionType<K, R> {

  R calculateCommission(K k);
}
