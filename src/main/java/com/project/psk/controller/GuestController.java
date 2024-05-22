package com.project.psk.controller;

import com.project.psk.model.dto.Guest.GuestInfoDTO;
import com.project.psk.model.entity.GuestEntity;
import com.project.psk.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping("/{id}")
    public ResponseEntity<GuestEntity> getGuestById(@PathVariable String id) {
        try {
            GuestEntity guest = guestService.getById(id);
            if (guest == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<GuestInfoDTO>> getGuestsByEventId(@PathVariable UUID eventId) {
        return ResponseEntity.ok(guestService.getAllByEventId(eventId));
    }

    @PostMapping
    public ResponseEntity<Void> createGuest(@RequestBody GuestInfoDTO guestInfoDTO) {
        guestService.createGuest(guestInfoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGuest(@PathVariable UUID id, @RequestBody GuestInfoDTO guestInfoDTO) {
        guestService.updateGuest(id, guestInfoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable UUID id) {
        guestService.deleteGuest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
