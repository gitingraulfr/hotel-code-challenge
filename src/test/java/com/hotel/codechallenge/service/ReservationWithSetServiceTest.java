package com.hotel.codechallenge.service;

import com.hotel.codechallenge.model.Reservation;
import com.hotel.codechallenge.model.dto.ReservationDTO;
import com.hotel.codechallenge.model.dto.response.ReservationResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservationWithSetServiceTest {

    @InjectMocks
    private ReservationWithSetService reservationService;

    @Test
    public void testGetAllReservations() {
        Reservation mockReservation = new Reservation();
        Set<Reservation> mockReservations = new HashSet<>();
        mockReservations.add(mockReservation);

        reservationService.reservations = mockReservations;

        ReservationResponseDTO response = reservationService.getAllReservations();
        List<ReservationDTO> data = (List<ReservationDTO>) response.getData();

        assertNotNull(response);
        assertEquals(1, data.size());
        assertEquals("These are all the existing reservations.", response.getMessage());
        // Add more assertions if needed
    }

    @Test
    public void testCreateReservation() {
        ReservationDTO reservationDTO = new ReservationDTO();
        ReservationResponseDTO response = reservationService.createReservation(reservationDTO);

        assertNotNull(response);
        assertEquals(1, reservationService.reservations.size()); // Check if reservation was added to the set
        // Add more assertions to verify the response
    }

    @Test
    public void testUpdateReservation() {
        Integer id = 1;
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(id);

        Reservation mockReservation = new Reservation();
        mockReservation.setId(id);
        mockReservation.setClientFullName("John Doe");
        mockReservation.setRoomNumber(101);

        reservationService.reservations = new HashSet<>();
        reservationService.reservations.add(mockReservation);

        ReservationResponseDTO<ReservationDTO> response = reservationService.updateReservation(id, reservationDTO);

        assertNotNull(response);
        ReservationDTO data = response.getData();
        assertEquals("John Doe", data.getClientFullName()); // Check if the update is reflected
        // Add more assertions to verify the response
    }
}