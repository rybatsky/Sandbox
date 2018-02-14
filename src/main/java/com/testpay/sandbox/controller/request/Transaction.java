package com.testpay.sandbox.controller.request;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class Transaction {
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("description")
    private String description;
}
