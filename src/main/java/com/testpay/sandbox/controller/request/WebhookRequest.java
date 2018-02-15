package com.testpay.sandbox.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebhookRequest {
    private String currency;
    private String amount;
    private String id;
    @JsonProperty("external_id")
    private String externalId;
    private String status;
    private String sha2sig;
}
