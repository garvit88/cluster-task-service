package com.test.cluster.response.dto;

import java.time.Instant;
import com.test.cluster.enums.Status;
import lombok.Data;

/**
 *  It is used for returning task entity response
 */
@Data
public class TaskResponseDto {

  private Long id;

  private Instant created;

  private Instant updated;

  private String title;

  private String description;

  private Status status;

  private Instant deadline;

}
