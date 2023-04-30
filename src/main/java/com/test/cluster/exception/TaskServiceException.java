package com.test.cluster.exception;

import com.test.cluster.enums.ExceptionConstants;

/**
 *  Customer TaskServiceException
 */
public class TaskServiceException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String message;
  private Integer code;


  public TaskServiceException(String message, Integer code) {
    super();
    this.message = message;
    this.code = code;
  }

  public TaskServiceException(ExceptionConstants exception) {
    super();
    this.message = exception.getMessage(exception);
    this.code = exception.getCode(exception);
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

}
