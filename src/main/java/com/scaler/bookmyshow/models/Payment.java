package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "payments")
public class Payment extends BaseModel
{
    private String referenceId;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
