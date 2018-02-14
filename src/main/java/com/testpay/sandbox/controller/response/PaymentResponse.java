package com.testpay.sandbox.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
public class PaymentResponse {
    private String id;
    @JsonProperty("create_time")
    private String createTime;
    private PaymentState state;
}
