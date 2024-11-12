package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name= "cities")
public class City extends BaseModel{
    private String cityname;
    @OneToMany
    @JoinColumn(name= "city_id")
    private List<Theatre> theatres;

}
