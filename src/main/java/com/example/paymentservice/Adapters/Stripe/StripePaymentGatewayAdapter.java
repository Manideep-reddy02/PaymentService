package com.example.paymentservice.Adapters.Stripe;

import com.example.paymentservice.Adapters.PaymentGatewayAdapter;
import com.stripe.Stripe;
import com.stripe.StripeClient;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGatewayAdapter implements PaymentGatewayAdapter {
    private StripeClient stripeClient;

    public StripePaymentGatewayAdapter(StripeClient stripeClient){
        this.stripeClient = stripeClient;
    }


    @Override
    public String createPaymentLink(long price) throws Exception{

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1QV9rRGAEcY9SeaZ2OgpfmwJ")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://www.scaler.com/academy/mentee-dashboard/todos")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return  paymentLink.getUrl();
    }
}
