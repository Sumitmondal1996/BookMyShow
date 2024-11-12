package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "movies")
public class Movie extends BaseModel{
    private String name;
    private double rating;
}
