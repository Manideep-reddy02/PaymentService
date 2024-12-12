package com.example.paymentservice.Adapters.Stripe;

import com.example.paymentservice.Adapters.PaymentGatewayAdapter;
import com.stripe.StripeClient;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGatewayAdapter implements PaymentGatewayAdapter {
    private StripeClient stripeClient;

    public  StripePaymentGatewayAdapter(){

    }
    public StripePaymentGatewayAdapter(StripeClient stripeClient){
        this.stripeClient = stripeClient;
    }


    @Override
    public String createPaymentLink(long price) throws Exception{
        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .setCurrency("inr")
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1Pwo7cLbeILF4TqhDP2UjHpP")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://scaler.com")
                                                        .build()
                                        )
                                        .build()
                        )
                        .setInvoiceCreation(
                                PaymentLinkCreateParams.InvoiceCreation.builder().setEnabled(true).build()
                        )
                        .setPhoneNumberCollection(
                                PaymentLinkCreateParams.PhoneNumberCollection.builder().setEnabled(false).build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.getUrl();
    }
}
