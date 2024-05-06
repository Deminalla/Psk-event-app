package com.project.psk.model.dto.Event;

import com.project.psk.model.enums.EventCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

//this dto is used in creating and updating
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventModifyDTO {
    private String title;
    private String description;
    private LocalDateTime date;
    private EventCategory category;
    private String location;
    private UUID organizer;
    private byte[] imageBytes;
    private BigDecimal price;
    private LocalDateTime endDate;
}
