package com.test.cluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.cluster.constants.ApplicationConstants;
import com.test.cluster.constants.RestURIConstants;
import com.test.cluster.helper.APIResponse;
import com.test.cluster.helper.ResponseHelper;
import com.test.cluster.request.dto.TaskRequestDto;
import com.test.cluster.response.dto.TaskResponseDto;
import com.test.cluster.service.TaskService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 * This is Task controller class responsible for all the CRUD operation on the Task entity
 */
@RestController
@RequestMapping(value = RestURIConstants.TASK_SERVICE)
@Slf4j
public class TaskController {

  @Autowired
  private ResponseHelper responseHelper;

  @Autowired
  private TaskService taskService;

  /**
   * This method is responsible for creating a new task
   */
  @PostMapping(value = RestURIConstants.CREATE_TASK_V1)
  public ResponseEntity<APIResponse> createTask(@Valid @RequestBody TaskRequestDto taskRequestDto) {
    log.info("Request to create task: {}", taskRequestDto);
    TaskResponseDto response = taskService.createTask(taskRequestDto);
    return responseHelper.getCreatedResponse(ApplicationConstants.TASK_CREATED_SUCCESSFULLY,
        response);
  }

  /**
   * This method is responsible for updating an existing task
   */
  @PutMapping(value = RestURIConstants.UPDATE_TASK_V1)
  public ResponseEntity<APIResponse> updateTask(@PathVariable(value = "id") Long id,
      @Valid @RequestBody TaskRequestDto taskRequestDto) {
    log.info("Request to update task: {}", taskRequestDto);
    TaskResponseDto response = taskService.updateTask(id, taskRequestDto);
    return responseHelper.getSucessResponse(ApplicationConstants.TASK_UPDATED_SUCCESSFULLY,
        response);
  }

  /**
   * This method is responsible for fetching an existing task
   */
  @GetMapping(value = RestURIConstants.GET_TASK_V1)
  public ResponseEntity<APIResponse> getTask(@PathVariable(value = "id") Long id) {
    log.info("Request to get task by id: {}", id);
    TaskResponseDto response = taskService.getTask(id);
    return responseHelper.getSucessResponse(ApplicationConstants.TASK_FETCHED_SUCCESSFULLY,
        response);
  }

  /**
   * This method is responsible for deleting an existing task
   */
  @DeleteMapping(value = RestURIConstants.DELETE_TASK_V1)
  public ResponseEntity<APIResponse> deleteTask(@PathVariable(value = "id") Long id) {
    log.info("Request to delete task by id: {}", id);
    taskService.deleteTask(id);
    return responseHelper.getSucessResponse(ApplicationConstants.TASK_DELETED_SUCCESSFULLY, null);
  }

}
