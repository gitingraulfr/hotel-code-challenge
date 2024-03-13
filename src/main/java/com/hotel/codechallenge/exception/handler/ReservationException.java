package com.hotel.codechallenge.exception.handler;

import com.hotel.codechallenge.constants.ReservationCodeEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ReservationException extends RuntimeException {

    @Getter
    private ReservationCodeEnum code;

    @Getter
    private HttpStatus httpStatus;

    public ReservationException(String message, ReservationCodeEnum code, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
