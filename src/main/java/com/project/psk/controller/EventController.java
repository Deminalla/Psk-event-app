package com.project.psk.controller;

import com.project.psk.model.dto.Event.EventInfoDTO;
import com.project.psk.model.dto.Event.EventModifyDTO;
import com.project.psk.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/events")
public class EventController {
    private final EventService eventService;

    @GetMapping("/{eventId}")
    ResponseEntity<EventInfoDTO> getById(@PathVariable UUID eventId) {
        return ResponseEntity.ok(eventService.getById(eventId));
    }

    @GetMapping
    ResponseEntity<List<EventInfoDTO>> getAll() {
        return ResponseEntity.ok(eventService.getAll());
    }

    @GetMapping("/organized/{organizer}")
    ResponseEntity<List<EventInfoDTO>> getAllByOrganizer(@PathVariable UUID organizer) {
        return ResponseEntity.ok(eventService.getAllByOrganizer(organizer));
    }

    @GetMapping("/attending/{userId}")
    ResponseEntity<List<EventInfoDTO>> getAllByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(eventService.getAllByUser(userId));
    }

    @PostMapping("/newEvent")
    ResponseEntity<EventInfoDTO> createEvent(@RequestBody EventModifyDTO eventModifyDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventModifyDTO));
    }

    @PutMapping("/update/{eventId}")
    ResponseEntity<EventInfoDTO> updateEvent(@PathVariable UUID eventId, @RequestBody EventModifyDTO eventModifyDTO) {
        return ResponseEntity.ok(eventService.updateEvent(eventId, eventModifyDTO));
    }

    @DeleteMapping("/delete/{eventId}")
    ResponseEntity<String> deleteEvent(@PathVariable UUID eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }

    @PostMapping("/addAttendee/{eventId}/{userId}")
    ResponseEntity<String> addAttendee(@PathVariable UUID eventId, @PathVariable UUID userId) {
        eventService.addAttendee(eventId, userId);
        return ResponseEntity.ok("Attendee added to event");
    }

    @DeleteMapping("/removeAttendee/{eventId}/{userId}")
    ResponseEntity<String> removeAttendee(@PathVariable UUID eventId, @PathVariable UUID userId) {
        eventService.removeAttendee(eventId, userId);
        return ResponseEntity.ok("Attendee removed from event");
    }
}
