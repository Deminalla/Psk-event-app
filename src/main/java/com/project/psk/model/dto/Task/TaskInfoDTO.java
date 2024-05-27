package com.project.psk.model.dto.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskInfoDTO {
    private UUID id;
    private String description;
    private UUID eventId;
    private UUID guestId;
    private boolean completed;
}
