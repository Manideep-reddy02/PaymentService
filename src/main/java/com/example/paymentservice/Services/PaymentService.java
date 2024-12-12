package com.example.paymentservice.Services;

import com.example.paymentservice.Adapters.PaymentGatewayAdapter;
import com.example.paymentservice.Adapters.PaymentGatewayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentGatewayStrategy paymentGatewayStrategy;

    public String CreatePaymentLink(long id)  {
        // 1. Get the order details from the order service
        // restTemplate.getForObject("http://orderservice.naman.dev/orders/{orderId}", Order.class, orderId);
        /// price = order.getPrice();
        Long price = 123L;

        // 2. Get a payment gateway based upon a `strategy`
        PaymentGatewayAdapter paymentGatewayAdapter =
                paymentGatewayStrategy.getPaymentGateway();

        // 3. Call the payment gateway to create a payment link

        String url ="";
        try {
            url =  paymentGatewayAdapter.createPaymentLink(price);

        }catch (Exception e){
            e.printStackTrace();
        }

        return url;
    }
}
