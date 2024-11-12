package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name= "screens")
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    @JoinColumn(name= "screen_id")
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<ScreenFeature> screenFeatures;
}
