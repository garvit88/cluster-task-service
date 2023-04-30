package com.test.cluster.entity;

import java.time.Instant;
import com.test.cluster.enums.Status;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This is task entity
 */
@Data
@Entity
@Table(name = "task")
@EqualsAndHashCode(callSuper = false)
public class Task extends ClusterBase {

  private static final long serialVersionUID = 1L;

  @NotBlank
  @Column(name = "title", nullable = false)
  private String title;

  @NotBlank
  @Column(name = "description", nullable = false)
  private String description;

  @Nonnull
  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private Status status;

  @Nonnull
  @Column(name = "deadline", nullable = false)
  private Instant deadline;

}
