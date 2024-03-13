package com.hotel.codechallenge.constants;

import lombok.Getter;

public enum ReservationCodeEnum {
    R_001("Success"),
    R_002("No available information"),
    R_003("Error during the process"),
    R_004("Reservation not found");

    @Getter
    private String description;

    private ReservationCodeEnum(String description) {
        this.description = description;
    }

}
