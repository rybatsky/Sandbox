package com.testpay.sandbox.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

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
