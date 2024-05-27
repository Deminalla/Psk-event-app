package com.project.psk.model.dto.Event;

import com.project.psk.model.enums.EventCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

//this dto is used in retrieving information of existing events
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventInfoDTO {
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime date;
    private EventCategory category;
    private String location;
    private UUID organizer;
    private String imageBytes;
    private BigDecimal price;
    private LocalDateTime endDate;
    private List<UUID> attendingUsers;
}
