package com.hotel.codechallenge.mapper;

import com.hotel.codechallenge.model.Reservation;
import com.hotel.codechallenge.model.dto.ReservationDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationMapper {

    public static ReservationDTO reservationEntityToDto(Reservation reservation) {
        return ReservationDTO.builder()
                .id(reservation.getId())
                .clientFullName(reservation.getClientFullName())
                .roomNumber(reservation.getRoomNumber())
                .reservationDates(reservation.getReservationDates())
                .build();
    }

    public static List<ReservationDTO> reservationEntityListToDtoList(List<Reservation> reservations) {
        return reservations.stream()
                .map(reservation -> ReservationDTO.builder()
                        .id(reservation.getId())
                        .clientFullName(reservation.getClientFullName())
                        .roomNumber(reservation.getRoomNumber())
                        .reservationDates(reservation.getReservationDates())
                        .build()
                ).collect(Collectors.toList());
    }

    public static Reservation reservationDtoToEntity(ReservationDTO reservationDTO) {
        return Reservation.builder()
                .id(reservationDTO.getId())
                .clientFullName(reservationDTO.getClientFullName())
                .roomNumber(reservationDTO.getRoomNumber())
                .reservationDates(reservationDTO.getReservationDates())
                .build();
    }

}