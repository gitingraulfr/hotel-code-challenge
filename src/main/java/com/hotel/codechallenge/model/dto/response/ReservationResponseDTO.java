package com.hotel.codechallenge.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReservationResponseDTO<T> {
    private T data;
    private String message;
    private String dateTime;
    private String code;
}
