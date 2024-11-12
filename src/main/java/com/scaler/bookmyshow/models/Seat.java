package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "seats")
public class Seat extends BaseModel{
    private String seatnumber;
    private int rowVal;
    private int colVal;
    @ManyToOne
    private SeatType seatType;

}
