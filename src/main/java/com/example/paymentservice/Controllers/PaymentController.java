package com.example.paymentservice.Controllers;

import com.example.paymentservice.Dtos.CreatePaymentLinkRequestDto;
import com.example.paymentservice.Dtos.CreatePaymentLinkResponseDto;
import com.example.paymentservice.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

   private PaymentService paymentService;
   public PaymentController(PaymentService paymentService){
       this.paymentService = paymentService;
   }

    @PostMapping("/")
    public CreatePaymentLinkResponseDto CreatePaymentLink
            (@RequestBody CreatePaymentLinkRequestDto requestDto) {
        String url = paymentService.CreatePaymentLink(requestDto.getId());

        CreatePaymentLinkResponseDto responseDto = new CreatePaymentLinkResponseDto();
        responseDto.setUrl(url);
        return  responseDto;
    }


}
