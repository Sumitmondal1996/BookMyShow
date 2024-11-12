package com.scaler.bookmyshow.controller;

import com.scaler.bookmyshow.dtos.CreateBookingRequestDto;
import com.scaler.bookmyshow.dtos.CreateBookingResponseDto;
import com.scaler.bookmyshow.dtos.ResponseStatus;
import com.scaler.bookmyshow.exception.ShowSeatNotFoundException;
import com.scaler.bookmyshow.exception.UserNotFoundException;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto createBookingRequestDto) throws UserNotFoundException, ShowSeatNotFoundException {

        Booking booking = bookingService.createBooking(createBookingRequestDto.getShowseatids(),
                createBookingRequestDto.getUser_id());
        CreateBookingResponseDto createBookingResponseDto  = new CreateBookingResponseDto();
        createBookingResponseDto.setBooking(booking);
        createBookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        if(booking==null)
        {
            createBookingResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return createBookingResponseDto;
    }


}
