package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exception.ShowSeatNotFoundException;
import com.scaler.bookmyshow.exception.UserNotFoundException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.BookingRepository;
import com.scaler.bookmyshow.repositories.ShowSeatIdRepository;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    UserRepository userRepository;
    ShowSeatIdRepository showSeatIdRepository;
    PriceCalculatorService priceCalculatorService;
    BookingRepository bookingRepository;
    public BookingService(UserRepository userRepository, ShowSeatIdRepository showSeatIdRepository, PriceCalculatorService priceCalculatorService, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showSeatIdRepository= showSeatIdRepository;
        this.priceCalculatorService = priceCalculatorService;
        this.bookingRepository = bookingRepository;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE) // used for taking a lock over the DB
    public Booking createBooking(List<Long> showseatids, Long user_id) throws UserNotFoundException, ShowSeatNotFoundException {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found with user_id " + user_id);
        }
        User user = optionalUser.get();

        List<ShowSeat> showSeats = showSeatIdRepository.findAllById(showseatids);
        for (ShowSeat showSeat: showSeats)
        {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw new ShowSeatNotFoundException(showSeat);
            }

        }

        for (ShowSeat showSeat: showSeats)  // this block is seperate because if the previous for loop fails after a certain iterations the status of those showseats will be staying as Blocked
        {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatIdRepository.save(showSeat); // to store in DB
        }

        Booking booking = new Booking();
        booking.setShowSeats(showSeats);
        // change the status to pending & call to paymentservice;
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(user);
        booking.setAmount(priceCalculatorService.calculateprice(showSeats));



        return bookingRepository.save(booking);

    }
}
