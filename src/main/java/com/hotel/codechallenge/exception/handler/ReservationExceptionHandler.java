package com.hotel.codechallenge.exception.handler;

import com.hotel.codechallenge.constants.ReservationCodeEnum;
import com.hotel.codechallenge.model.dto.response.ReservationResponseDTO;
import com.hotel.codechallenge.util.FormatterUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReservationExceptionHandler {

    @ExceptionHandler(value = {Exception.class, ReservationException.class})
    public ResponseEntity<ReservationResponseDTO<?>> handleExceptions(Exception e) {
        ReservationResponseDTO<String> response = new ReservationResponseDTO<>();
        response.setMessage("An error occurred while processing the request");
        response.setDateTime(FormatterUtility.getDatetime());
        response.setCode(ReservationCodeEnum.R_003.name());

        if (e instanceof ReservationException) {
            response.setMessage(e.getMessage());
            response.setCode(ReservationCodeEnum.R_004.name());
            return new ResponseEntity(response, ((ReservationException) e).getHttpStatus());
        }

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
