package com.test.cluster.enums;

/**
 * This class contains all application exception constants
 */
public enum ExceptionConstants {

  NO_TASK_FOUND(1001, "no.task.found");

  private Integer code;
  private String message;

  ExceptionConstants() {

  }

  ExceptionConstants(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getMessage(ExceptionConstants exception) {
    return exception.message;
  }

  public Integer getCode(ExceptionConstants exception) {
    return exception.code;
  }

}
