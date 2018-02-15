package com.testpay.sandbox.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Amount {
    @JsonProperty("amount")
    private String value;
    @JsonProperty("currency")
    private String currency;
}
