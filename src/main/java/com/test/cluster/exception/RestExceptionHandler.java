package com.test.cluster.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.test.cluster.constants.ApplicationConstants;
import com.test.cluster.constants.ResponseConstants;
import com.test.cluster.helper.APIResponse;
import com.test.cluster.helper.ResponseHelper;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

/**
 * This class defines all the Exception Handlers to handle all kind of exceptions
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class RestExceptionHandler {

  @Autowired
  private ResponseHelper responseHelper;

  /**
   * This handles all the MethodArgumentNotValidExceptions
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<APIResponse> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception, WebRequest request) {
    log.error("MethodArgumentNotValidException occured: {} ", exception.getMessage());
    StringBuilder sb = new StringBuilder();
    exception.getBindingResult().getAllErrors().forEach(error -> {
      sb.append(((FieldError) error).getField());
      sb.append(ApplicationConstants.BLANK_SPACE);
      sb.append(error.getDefaultMessage());
      sb.append(ApplicationConstants.COMMA);
      sb.append(ApplicationConstants.BLANK_SPACE);
    });
    sb.replace(sb.length() - 2, sb.length(), "");
    return responseHelper.getCustomFailureResponse(sb.toString(),
        ResponseConstants.VALIDATION_FAILED_CODE, HttpStatus.BAD_REQUEST);
  }

  /**
   * This handles all the custom exceptions
   */
  @ExceptionHandler(TaskServiceException.class)
  public ResponseEntity<APIResponse> handleCustomException(TaskServiceException exception,
      WebRequest request) {
    log.error("TaskServiceException occured: {}", exception.getMessage());
    return responseHelper.getCustomFailureResponse(exception.getMessage(), exception.getCode(),
        HttpStatus.BAD_REQUEST);
  }

  /**
   * This handles all the ConstraintViolationException
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<APIResponse> handleConstraintViolationException(Exception exception,
      WebRequest request) {
    log.error("ConstraintViolationException occured: {} ", exception.getMessage());
    return responseHelper.getBadRequestResponse(exception.getMessage());
  }

  /**
   * This handles all the generic exceptions
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<APIResponse> handleGenericException(Exception exception,
      WebRequest request) {
    log.error("Exception occured: {} ", exception.getMessage());
    return responseHelper.getFailureResponse(exception.getMessage());
  }

}
