package com.project.psk.service;

import com.project.psk.model.dto.Task.TaskInfoDTO;
import com.project.psk.model.entity.EventEntity;
import com.project.psk.model.entity.TaskEntity;
import com.project.psk.mybatis.mapper.GuestMapper;
import com.project.psk.repository.EventRepository;
import com.project.psk.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final EventRepository eventRepository;
    private final GuestMapper guestMapper;

    @Transactional
    public TaskEntity addTask(UUID eventId, UUID guestId, String description) {
        EventEntity event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        if (guestMapper.getById(guestId.toString()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found");
        }

        TaskEntity task = new TaskEntity();
        task.setDescription(description);
        task.setEvent(event);
        task.setGuestId(guestId);
        task.setCompleted(false);

        return taskRepository.save(task);
    }

    @Transactional
    public void updateTask(UUID taskId, String description, boolean completed) {
        TaskEntity task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

        task.setDescription(description);
        task.setCompleted(completed);

        taskRepository.save(task);
    }

    @Transactional
    public List<TaskInfoDTO> getTasksByGuestId(UUID guestId) {
        List<TaskEntity> tasks = taskRepository.findByGuestId(guestId);
        return tasks.stream()
                .map(task -> new TaskInfoDTO(task.getId(), task.getDescription(), task.getEvent().getId(), task.getGuestId(), task.isCompleted()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteTask(UUID taskId) {
        TaskEntity task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        taskRepository.delete(task);
    }
}
