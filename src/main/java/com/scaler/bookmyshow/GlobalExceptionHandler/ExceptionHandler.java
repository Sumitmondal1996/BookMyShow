package com.scaler.bookmyshow.GlobalExceptionHandler;

import com.scaler.bookmyshow.exception.ShowSeatNotFoundException;
import com.scaler.bookmyshow.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFoundException()
    {
        System.out.println("User Not Found Exception");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ShowSeatNotFoundException.class)
    public void handleShowSeatNotFoundException()
    {
        System.out.println("Show Seat Not Found Exception");
    }
}
