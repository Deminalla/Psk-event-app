package com.project.psk.service;

import com.project.psk.model.dto.Guest.GuestInfoDTO;
import com.project.psk.model.entity.GuestEntity;
import com.project.psk.mybatis.mapper.GuestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestMapper guestMapper;

    public void createGuest(GuestInfoDTO guestInfoDTO) {
        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setId(guestInfoDTO.getId() != null ? guestInfoDTO.getId() : UUID.randomUUID());
        guestEntity.setName(guestInfoDTO.getName());
        guestEntity.setEmail(guestInfoDTO.getEmail());
        guestEntity.setEventId(guestInfoDTO.getEventId());
        guestMapper.insert(guestEntity);
    }

    public GuestEntity getById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format", e);
        }
        return guestMapper.getById(id);
    }

    public List<GuestInfoDTO> getAllByEventId(UUID eventId) {
        List<GuestEntity> guestEntities = guestMapper.getAllByEventId(eventId.toString()); // Convert UUID to String
        return guestEntities.stream()
                .map(guest -> new GuestInfoDTO(guest.getId(), guest.getName(), guest.getEmail(), guest.getEventId()))
                .collect(Collectors.toList());
    }

    public void updateGuest(UUID id, GuestInfoDTO guestInfoDTO) {
        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setId(id);
        guestEntity.setName(guestInfoDTO.getName());
        guestEntity.setEmail(guestInfoDTO.getEmail());
        guestEntity.setEventId(guestInfoDTO.getEventId());
        guestMapper.update(guestEntity);
    }

    public void deleteGuest(UUID id) {
        guestMapper.delete(id);
    }
}
