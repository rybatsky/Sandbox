package com.testpay.sandbox.controller.request;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class Amount {
    @JsonProperty("amount")
    private String value;
    @JsonProperty("currency")
    private String currency;
}
