package com.kparlar.iett.consumer.entity.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;


public enum MesssageLineStatus {
  PRODUCED("PRODUCER"),
  CONSUMED("CONSUMED"),
  ERROR_PRODuCED("ERROR_PRODUCED"),
  ERROR_CONSUMED("ERROR_CONSUMED");

  private final String value;

  MesssageLineStatus(String value){ this.value = value;}

  public static MesssageLineStatus fromValue(String status) {
    return Arrays.stream(MesssageLineStatus.values())
        .filter(data -> data.value.equals(status))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Not a valid Message Line Status: " + status));
  }
}
