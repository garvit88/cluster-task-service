package com.test.cluster.entity;

import java.io.Serializable;
import java.time.Instant;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

/**
 * This class is base entity and can be used further by other/ new classes
 */
@MappedSuperclass
@Data
public abstract class ClusterBase implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Nonnull
  @Column(name = "created", nullable = false, updatable = false)
  private Instant created = Instant.now();

  @Nonnull
  @Column(name = "updated", nullable = false)
  private Instant updated = Instant.now();

  @PrePersist
  void prePersist() {
    setCreated(Instant.now());
    setUpdated(Instant.now());
  }

  @PreUpdate
  void preUpdate() {
    setUpdated(Instant.now());
  }

}
