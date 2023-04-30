package com.test.cluster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.test.cluster.entity.Task;

/**
 *  Repository for the Task entity
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
