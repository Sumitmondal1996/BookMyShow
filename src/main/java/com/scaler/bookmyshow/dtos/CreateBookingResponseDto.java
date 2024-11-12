package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.Booking;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;

}
