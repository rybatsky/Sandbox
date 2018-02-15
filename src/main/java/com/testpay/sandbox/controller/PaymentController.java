package com.testpay.sandbox.controller;


import com.testpay.sandbox.controller.request.PaymentRequest;
import com.testpay.sandbox.controller.response.PaymentResponse;
import com.testpay.sandbox.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController
{
    private final PaymentService paymentService;


    public PaymentController(final PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }


    @PostMapping("/payments/payment")
    public PaymentResponse payment(@RequestBody final PaymentRequest request)
    {
        return paymentService.payment(request);
    }
}
