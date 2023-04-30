package com.test.cluster.service;

/**
 * Interface for Task
 */
import com.test.cluster.request.dto.TaskRequestDto;
import com.test.cluster.response.dto.TaskResponseDto;

public interface TaskService {

  TaskResponseDto createTask(TaskRequestDto taskRequestDto);

  TaskResponseDto updateTask(Long id, TaskRequestDto taskRequestDto);

  TaskResponseDto getTask(Long id);

  void deleteTask(Long id);

}
