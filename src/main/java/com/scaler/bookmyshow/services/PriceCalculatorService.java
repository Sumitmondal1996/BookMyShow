package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.ShowSeatType;
import com.scaler.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    public PriceCalculatorService  (ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculateprice(List<ShowSeat> showSeats)
    {
        Show show = showSeats.get(0).getShow();
        int price = 0;
        List<ShowSeatType> showSeatTypes= showSeatTypeRepository.findAllByShow(show);
        for(ShowSeatType showSeatType:showSeatTypes)
        {
            for(ShowSeat showSeat:showSeats)
            {
                if(showSeatType.getSeatType().equals(showSeat.getSeat().getSeatType()))
                {
                    price += showSeatType.getPrice();
                    break;
                }
            }
        }

        return price;
    }
}
