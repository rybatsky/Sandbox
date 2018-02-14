package com.testpay.sandbox.controller.request;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class Payer {
    @JsonProperty("email")
    private String email;
}