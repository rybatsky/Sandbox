package com.testpay.sandbox.controller.request;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

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
