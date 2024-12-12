package com.example.paymentservice.Adapters;

public interface PaymentGatewayAdapter {
    String createPaymentLink(long price) throws Exception;
}
