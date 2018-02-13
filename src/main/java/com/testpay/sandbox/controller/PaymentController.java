package com.testpay.sandbox.controller;

import com.testpay.sandbox.controller.request.PaymentRequest;
import com.testpay.sandbox.controller.response.PaymentResponse;
import com.testpay.sandbox.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments/payment")
    public PaymentResponse payment(@RequestBody PaymentRequest request) {
        return paymentService.payment(request);
    }
}
