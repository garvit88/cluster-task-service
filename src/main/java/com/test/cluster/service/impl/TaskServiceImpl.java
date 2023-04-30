package com.test.cluster.service.impl;

/**
 * Implementation class for Task
 */
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.cluster.entity.Task;
import com.test.cluster.enums.ExceptionConstants;
import com.test.cluster.exception.TaskServiceException;
import com.test.cluster.repository.TaskRepository;
import com.test.cluster.request.dto.TaskRequestDto;
import com.test.cluster.response.dto.TaskResponseDto;
import com.test.cluster.service.TaskService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository taskRepository;

  /**
   * Implementation method for creating new task
   */
  @Override
  public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
    log.info("Creating task: {}", taskRequestDto);
    validateRequest(taskRequestDto);
    Task task = convert(taskRequestDto);
    task = taskRepository.save(task);
    return convert(task);
  }

  /**
   * Implementation method for updating an existing new task
   * 
   */
  @Override
  public TaskResponseDto updateTask(Long id, TaskRequestDto taskRequestDto) {
    log.info("Updating task id: {} with request: {}", id, taskRequestDto);
    // if there are multiple call to update same resource in that case we can implement versioning in Task
    validateRequest(taskRequestDto);
    Task task = getTaskById(id);
    BeanUtils.copyProperties(taskRequestDto, task);
    task = taskRepository.save(task);
    return convert(task);
  }

  /**
   * Implementation method for fetching an existing new task
   */
  @Override
  public TaskResponseDto getTask(Long id) {
    log.info("Getting task id: {}", id);
    Task task = getTaskById(id);
    return convert(task);
  }

  /**
   * Implementation method for deleting an existing new task
   */
  @Override
  public void deleteTask(Long id) {
    log.info("Deleting task id: {}", id);
    Task task = getTaskById(id);
    taskRepository.deleteById(task.getId());
  }

  /**
   * This method id used for fetching task from db and if not found it throws an exception
   */
  private Task getTaskById(Long id) {
    log.info("Fetching task: {} from db", id);
    Optional<Task> task = taskRepository.findById(id);
    if (task.isPresent()) {
      log.debug("Task found with id: {}", id);
      return task.get();
    } else {
      log.debug("No Task found with id: {}", id);
      throw new TaskServiceException(ExceptionConstants.NO_TASK_FOUND);
    }
  }

  /**
   * This method id used for converting TaskRequestDto into Task entity
   * 
   * Mappers can also be implemented instead of this
   */
  private Task convert(TaskRequestDto taskRequestDto) {
    log.info("Converting TaskRequestDto into Task");
    Task task = new Task();
    task.setTitle(taskRequestDto.getTitle());
    task.setDescription(taskRequestDto.getDescription());
    task.setStatus(taskRequestDto.getStatus());
    task.setDeadline(taskRequestDto.getDeadline());
    return task;
  }

  /**
   * This method id used for converting Task entity into TaskResponseDto
   * 
   * Mappers can also be implemented instead of this
   */
  private TaskResponseDto convert(Task task) {
    log.info("Converting Task into TaskResponseDto");
    TaskResponseDto response = new TaskResponseDto();
    response.setTitle(task.getTitle());
    response.setDescription(task.getDescription());
    response.setStatus(task.getStatus());
    response.setDeadline(task.getDeadline());
    response.setId(task.getId());
    response.setCreated(task.getCreated());
    response.setUpdated(task.getUpdated());
    return response;
  }

  /**
   * Business validation method for validating task request
   */
  private void validateRequest(TaskRequestDto taskRequestDto) {
    log.info("validating taskRequestDto");
    // business validation can be added here if there are any
  }


}
