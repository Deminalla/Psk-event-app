package com.project.psk.repository;

import com.project.psk.model.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.UUID;

@Repository
@ApplicationScope
public interface EventRepository extends JpaRepository<EventEntity, UUID> {
    List<EventEntity> findAllByOrganizerId(UUID organizerId);
    @Query("SELECT e FROM EventEntity e JOIN e.attendingUsers u WHERE u.id = :userId")
    List<EventEntity> findAllByUser(UUID userId);
}
