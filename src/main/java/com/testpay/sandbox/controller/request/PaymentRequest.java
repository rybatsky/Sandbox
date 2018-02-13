package com.testpay.sandbox.controller.request;

import lombok.Data;

@Data
public class PaymentRequest {
    private PaymentIntent intent;
    private String notificationUrl;
    private Payer payer;
    private Transaction transaction;
}
