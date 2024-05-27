package com.project.psk.controller;

import com.project.psk.model.dto.Task.TaskInfoDTO;
import com.project.psk.model.dto.Task.TaskRequest;
import com.project.psk.model.dto.Task.TaskUpdateRequest;
import com.project.psk.model.entity.TaskEntity;
import com.project.psk.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskRequest taskRequest) {
        TaskEntity newTask = taskService.addTask(taskRequest.getEventId(), taskRequest.getGuestId(), taskRequest.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Void> updateTask(@PathVariable UUID taskId, @RequestBody TaskUpdateRequest taskUpdateRequest) {
        taskService.updateTask(taskId, taskUpdateRequest.getDescription(), taskUpdateRequest.isCompleted());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/guest/{guestId}")
    public ResponseEntity<List<TaskInfoDTO>> getTasksByGuestId(@PathVariable UUID guestId) {
        return ResponseEntity.ok(taskService.getTasksByGuestId(guestId));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
