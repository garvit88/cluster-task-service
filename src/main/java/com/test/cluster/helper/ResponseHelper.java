package com.test.cluster.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.test.cluster.config.Translator;
import com.test.cluster.constants.ResponseConstants;

/**
 *  Generic class that can be used for returning responses from the application
 */
@Component
public class ResponseHelper {

  public ResponseEntity<APIResponse> getSucessResponse(String message, Object data) {
    return buildResponseEntity(new APIResponse(Translator.toLocale(message),
        ResponseConstants.SUCCESS, ResponseConstants.SUCCESS_CODE, data), HttpStatus.OK);
  }

  public ResponseEntity<APIResponse> getCreatedResponse(String message, Object data) {
    return buildResponseEntity(new APIResponse(Translator.toLocale(message),
        ResponseConstants.CERATED, ResponseConstants.CREATED_CODE, data), HttpStatus.CREATED);
  }

  public ResponseEntity<APIResponse> getBadRequestResponse(String message) {
    return buildResponseEntity(new APIResponse(Translator.toLocale(message),
        ResponseConstants.BAD_REQUEST, ResponseConstants.BAD_REQUEST_CODE, null),
        HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<APIResponse> getFailureResponse(String message) {
    return buildResponseEntity(
        new APIResponse(Translator.toLocale(message), ResponseConstants.INTERNAL_SERVER_ERROR,
            ResponseConstants.INTERNAL_SERVER_ERROR_CODE, null),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public ResponseEntity<APIResponse> getCustomFailureResponse(String message, Integer statusCode,
      HttpStatus httpStatus) {
    return buildResponseEntity(new APIResponse(Translator.toLocale(message),
        ResponseConstants.BAD_REQUEST, statusCode, null), httpStatus);
  }

  private ResponseEntity<APIResponse> buildResponseEntity(APIResponse apiResponse,
      HttpStatus httpStatus) {
    return new ResponseEntity<>(apiResponse, httpStatus);
  }

}
