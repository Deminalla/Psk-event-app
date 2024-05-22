package com.project.psk.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestEntity {
    private UUID id;
    private String name;
    private String email;
    private UUID eventId;
}
