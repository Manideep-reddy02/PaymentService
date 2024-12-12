package com.example.paymentservice.Adapters;

import com.example.paymentservice.Adapters.Stripe.StripePaymentGatewayAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayStrategy {
   private StripePaymentGatewayAdapter stripePaymentGatewayAdapter;

   public PaymentGatewayStrategy(StripePaymentGatewayAdapter stripePaymentGatewayAdapter){
       this.stripePaymentGatewayAdapter =stripePaymentGatewayAdapter;
   }
    public PaymentGatewayAdapter getPaymentGateway(){
        return new StripePaymentGatewayAdapter();
    }
}
