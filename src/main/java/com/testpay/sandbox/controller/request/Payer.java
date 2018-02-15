package com.testpay.sandbox.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Payer {
    @JsonProperty("email")
    private String email;
}