package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name= "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date stat_time;
    private Date end_time;
    @ManyToOne
    private Screen screen;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)

    private List<ScreenFeature> screen_features;
}
