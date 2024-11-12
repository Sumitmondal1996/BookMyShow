package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {
    private List<Long> showseatids;
    private Long user_id;
}
