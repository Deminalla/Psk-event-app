package com.project.psk.model.entity;

import com.project.psk.model.enums.EventCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventCategory category;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name="organizer_id", nullable=false)
    private UserEntity organizer;

    @Column(name = "image_bytes")
    private byte[] imageBytes;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @ManyToMany
    private List<UserEntity> attendingUsers;
}
