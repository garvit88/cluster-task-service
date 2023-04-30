package com.test.cluster.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *  APIResponse structure for all the responses
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

  private String message;
  private String status;
  private Integer statusCode;
  private Object data;

}
