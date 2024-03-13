package com.hotel.codechallenge.service;

import com.hotel.codechallenge.model.dto.ReservationDTO;
import com.hotel.codechallenge.model.dto.response.ReservationResponseDTO;

public interface IReservationService {
    ReservationResponseDTO getAllReservations();
    ReservationResponseDTO createReservation(ReservationDTO reservationDTO);
    ReservationResponseDTO updateReservation(Integer id, ReservationDTO reservationDTO);
}
