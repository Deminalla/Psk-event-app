package com.project.psk.model.dto.Guest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestModifyDTO {
    private UUID id;
    private String name;
    private String email;
    private UUID eventId;
}
