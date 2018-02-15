package com.testpay.sandbox.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {
    private String id;
    @JsonProperty("create_time")
    private String createTime;
    private PaymentState state;
}
