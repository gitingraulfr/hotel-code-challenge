package com.hotel.codechallenge.controller;

import com.hotel.codechallenge.model.dto.ReservationDTO;
import com.hotel.codechallenge.model.dto.response.ReservationResponseDTO;
import com.hotel.codechallenge.service.ReservationWithDbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hotel/db")
public class ReservationDbController {
    private final ReservationWithDbService reservationWithDbService;

    public ReservationDbController(ReservationWithDbService reservationWithDbService) {
        this.reservationWithDbService = reservationWithDbService;
    }

    @GetMapping("/reservation")
    public ResponseEntity<ReservationResponseDTO> getAllReservations() {
        return ResponseEntity.ok(reservationWithDbService.getAllReservations());
    }

    @PostMapping("/reservation")
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.ok(reservationWithDbService.createReservation(reservationDTO));
    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity<ReservationResponseDTO> updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.ok(reservationWithDbService.updateReservation(id, reservationDTO));
    }
}