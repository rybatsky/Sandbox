package com.testpay.sandbox.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentRequest {
    @JsonProperty("intent")
    private PaymentIntent intent;
    @JsonProperty("notification_url")
    private String notificationUrl;
    @JsonProperty("payer")
    private Payer payer;
    @JsonProperty("transaction")
    private Transaction transaction;
}
