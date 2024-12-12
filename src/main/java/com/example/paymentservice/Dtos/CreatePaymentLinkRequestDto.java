package com.example.paymentservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentLinkRequestDto {
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
