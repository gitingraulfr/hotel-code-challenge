package com.hotel.codechallenge.service;

import com.hotel.codechallenge.constants.ReservationCodeEnum;
import com.hotel.codechallenge.dao.repository.ReservationRepository;
import com.hotel.codechallenge.exception.handler.ReservationException;
import com.hotel.codechallenge.mapper.ReservationMapper;
import com.hotel.codechallenge.model.Reservation;
import com.hotel.codechallenge.model.dto.ReservationDTO;
import com.hotel.codechallenge.model.dto.response.ReservationResponseDTO;
import com.hotel.codechallenge.util.FormatterUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationWithDbService implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ReservationResponseDTO getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        if (reservations != null && !reservations.isEmpty()) {
            return ReservationResponseDTO.builder()
                    .data(ReservationMapper.reservationEntityListToDtoList(reservations))
                    .message("These are all the existing reservations.")
                    .dateTime(FormatterUtility.getDatetime())
                    .code(ReservationCodeEnum.R_001.name())
                    .build();
        } else {
            return ReservationResponseDTO.builder()
                    .data(Collections.emptyList())
                    .message("No reservations for today.")
                    .dateTime(FormatterUtility.getDatetime())
                    .code(ReservationCodeEnum.R_002.name())
                    .build();
        }
    }

    @Override
    public ReservationResponseDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.save(ReservationMapper.reservationDtoToEntity(reservationDTO));
        return ReservationResponseDTO.builder()
                .data(ReservationMapper.reservationEntityToDto(reservation))
                .message("Reservation created successfully!")
                .dateTime(FormatterUtility.getDatetime())
                .code(ReservationCodeEnum.R_001.name())
                .build();
    }

    @Override

    public ReservationResponseDTO updateReservation(Integer id, ReservationDTO reservationDTO) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setId(reservationDTO.getId());
            reservation.setClientFullName(reservationDTO.getClientFullName());
            reservation.setRoomNumber(reservationDTO.getRoomNumber());
            reservation.setReservationDates(reservationDTO.getReservationDates());
            reservationRepository.save(reservation);

            return ReservationResponseDTO.builder()
                    .data(ReservationMapper.reservationEntityToDto(reservation))
                    .message("Reservation updated successfully!")
                    .dateTime(FormatterUtility.getDatetime())
                    .code(ReservationCodeEnum.R_001.name())
                    .build();
        } else {
            throw new ReservationException("Reservation with id " + id + " not found", ReservationCodeEnum.R_004, HttpStatus.NOT_FOUND);
        }
    }
}
