package com.scaler.bookmyshow.exception;

import com.scaler.bookmyshow.models.ShowSeat;

public class ShowSeatNotFoundException extends Exception{
    public ShowSeatNotFoundException(ShowSeat showSeat)
    {
        super("Seat "+ showSeat.getSeat().getId() + "in show of show id "+ showSeat.getShow().getId() + " is not available");
    }
}
