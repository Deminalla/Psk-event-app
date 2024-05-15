package com.project.psk.repository;

import com.project.psk.model.entity.EventEntity;
import com.project.psk.model.enums.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
@ApplicationScope
public interface EventRepository extends JpaRepository<EventEntity, UUID> {
    List<EventEntity> findAllByOrganizerId(UUID organizerId);
    @Query("SELECT e FROM EventEntity e JOIN e.attendingUsers u WHERE u.id = :userId")
    List<EventEntity> findAllByUser(UUID userId);

    @Query("SELECT e FROM EventEntity e WHERE " +
            "(TRUE = :#{#category == null} OR e.category = :category) " +
            "AND (TRUE = :#{#title == null} OR e.title = :title) " +
            "AND (TRUE = :#{#startDate == null} OR e.date >= :startDate) " +
            "AND (TRUE = :#{#endDate == null} OR e.endDate <= :endDate) " +
            "AND (TRUE = :#{#minPrice == null} OR e.price >= :minPrice)" +
            "AND (TRUE = :#{#maxPrice == null} OR e.price <= :maxPrice)")
    List<EventEntity> filterEventsByOptionalParameters(@Param("category") EventCategory category,
                                                        @Param("title") String title,
                                                        @Param("startDate") LocalDateTime startDate,
                                                        @Param("endDate") LocalDateTime endDate,
                                                        @Param("minPrice") BigDecimal minPrice,
                                                        @Param("maxPrice") BigDecimal maxPrice);
}
