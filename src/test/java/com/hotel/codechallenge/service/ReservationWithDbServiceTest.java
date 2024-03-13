package com.hotel.codechallenge.service;

import com.hotel.codechallenge.dao.repository.ReservationRepository;
import com.hotel.codechallenge.model.Reservation;
import com.hotel.codechallenge.model.dto.ReservationDTO;
import com.hotel.codechallenge.model.dto.response.ReservationResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservationWithDbServiceTest {

    @InjectMocks
    private ReservationWithDbService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Test
    public void testGetAllReservations() {
        List<Reservation> mockReservations = Collections.singletonList(new Reservation());

        when(reservationRepository.findAll()).thenReturn(mockReservations);

        ReservationResponseDTO response = reservationService.getAllReservations();
        List<ReservationDTO> data = (List<ReservationDTO>) response.getData();

        assertNotNull(response);
        assertEquals(1, data.size());
        assertEquals("These are all the existing reservations.", response.getMessage());
    }

    @Test
    public void testCreateReservation() {
        ReservationDTO reservationDTO = new ReservationDTO();
        Reservation mockReservation = new Reservation(); // Create a mock Reservation

        when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(mockReservation);

        ReservationResponseDTO response = reservationService.createReservation(reservationDTO);

        assertNotNull(response);
    }

    @Test
    public void testUpdateReservation() {
        Integer id = 1;
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(id);
        Reservation mockReservation = new Reservation(); // Create a mock Reservation

        when(reservationRepository.findById(id)).thenReturn(Optional.of(mockReservation));

        ReservationResponseDTO response = reservationService.updateReservation(id, reservationDTO);

        assertNotNull(response);
    }
}