package com.test.cluster.enums;

/**
 * Status enum
 */
public enum Status {

  PENDING("Pending"), IN_PROGRESS("In Progress"), COMPLETED("Completed");

  private String value;

  Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
