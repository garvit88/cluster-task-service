package com.test.cluster.request.dto;

import java.time.Instant;
import com.test.cluster.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *  It is used for creating and updating task entity
 */
@Data
public class TaskRequestDto {

  @NotBlank
  private String title;

  @NotBlank
  private String description;

  @NotNull
  private Status status;

  @NotNull
  private Instant deadline;

}
