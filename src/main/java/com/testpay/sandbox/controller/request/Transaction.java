package com.testpay.sandbox.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Transaction {
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("description")
    private String description;
}
