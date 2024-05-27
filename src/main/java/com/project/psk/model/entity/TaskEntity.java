package com.project.psk.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonIgnore
    private EventEntity event;

    @Column(name = "guest_id", nullable = false)
    private UUID guestId;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    public void setEventId(UUID eventId) {
        this.event = new EventEntity();
        this.event.setId(eventId);
    }
}