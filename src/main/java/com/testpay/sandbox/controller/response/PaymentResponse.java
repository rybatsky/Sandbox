package com.testpay.sandbox.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {
    private String id;
    private String createTime;
    private PaymentState state;
}
