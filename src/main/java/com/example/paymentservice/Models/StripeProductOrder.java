package com.example.paymentservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StripeProductOrder extends BaseModel{
    private Long productId;
    private String stripePriceID;
    private String stripeProductId;
}
