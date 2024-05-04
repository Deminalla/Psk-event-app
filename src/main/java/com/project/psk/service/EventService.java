package com.project.psk.service;

import com.project.psk.mapper.EventMapper;
import com.project.psk.model.dto.Event.EventInfoDTO;
import com.project.psk.model.dto.Event.EventModifyDTO;
import com.project.psk.model.entity.EventEntity;
import com.project.psk.model.entity.UserEntity;
import com.project.psk.model.enums.EventCategory;
import com.project.psk.repository.EventRepository;
import com.project.psk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequestScope
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final EventMapper eventMapper;

    @Transactional
    public EventInfoDTO getById(UUID id) {
        Optional<EventEntity> eventEntity = eventRepository.findById(id);
        if(eventEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

        return eventMapper.entityToInfoDto(eventEntity.get());
    }

    @Transactional
    public List<EventInfoDTO> getAll() {
        return eventMapper.entityListToInfoDtoList(
                eventRepository.findAll());
    }

    @Transactional
    public List<EventInfoDTO> getAllByOrganizer(UUID organizer) {
        return eventMapper.entityListToInfoDtoList(
                eventRepository.findAllByOrganizerId(organizer));
    }

    @Transactional
    public List<EventInfoDTO> getAllByUser(UUID userId) {
        return eventMapper.entityListToInfoDtoList(
                eventRepository.findAllByUser(userId));
    }

    @Transactional
    public EventInfoDTO createEvent(EventModifyDTO eventModifyDTO) {
        EventEntity eventEntity = eventMapper.modifyDtoToEntity(eventModifyDTO);
        Optional<UserEntity> organizer = userRepository.findById(eventModifyDTO.getOrganizer());
        if(organizer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organizer not found");
        }
        eventEntity.setOrganizer(organizer.get());

        return eventMapper.entityToInfoDto(
                eventRepository.save(eventEntity));
    }

    @Transactional
    public EventInfoDTO updateEvent(UUID eventId, EventModifyDTO eventModifyDTO) {
        Optional<EventEntity> optionalFoundEvent = eventRepository.findById(eventId);
        if(optionalFoundEvent.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
        EventEntity foundEvent = optionalFoundEvent.get();

        foundEvent.setDate(eventModifyDTO.getDate());
        foundEvent.setCategory(eventModifyDTO.getCategory());
        foundEvent.setDescription(eventModifyDTO.getDescription());
        foundEvent.setLocation(eventModifyDTO.getLocation());
        foundEvent.setEndDate(eventModifyDTO.getEndDate());
        foundEvent.setPrice(eventModifyDTO.getPrice());
        foundEvent.setImageBytes(eventModifyDTO.getImageBytes());
        foundEvent.setTitle(eventModifyDTO.getTitle());

        return eventMapper.entityToInfoDto(
                eventRepository.save(foundEvent));
    }
    @Transactional
    public void deleteEvent(UUID eventId) {
        Optional<EventEntity> optionalFoundEvent = eventRepository.findById(eventId);
        if(optionalFoundEvent.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

        eventRepository.delete(optionalFoundEvent.get());
    }

    @Transactional
    public void addAttendee(UUID eventId, UUID userId) {
        EventEntity eventEntity = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        eventEntity.getAttendingUsers().add(userEntity);
        eventRepository.save(eventEntity);
    }

    @Transactional
    public void removeAttendee(UUID eventId, UUID userId) {
        EventEntity eventEntity = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        eventEntity.getAttendingUsers().remove(userEntity);
        eventRepository.save(eventEntity);
    }

    @Transactional
    public List<EventInfoDTO> filterEventsByOptionalParameters(EventCategory category, String title,
                                                               LocalDate startDate, LocalDate endDate,
                                                               BigDecimal minPrice, BigDecimal maxPrice){

        List<EventEntity> filteredEvents = eventRepository.filterEventsByOptionalParameters(category, title,
                startDate != null ? startDate.atStartOfDay() : null,
                endDate != null ? endDate.atTime(LocalTime.MAX) : null, minPrice, maxPrice);
        return eventMapper.entityListToInfoDtoList(filteredEvents);
    }
}
