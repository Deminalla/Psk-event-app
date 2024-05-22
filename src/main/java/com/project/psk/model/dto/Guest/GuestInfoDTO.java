package com.project.psk.model.dto.Guest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestInfoDTO {
    private UUID id;
    private String name;
    private String email;
    private UUID eventId;
}
