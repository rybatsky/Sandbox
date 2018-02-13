package com.testpay.sandbox.model;

import com.testpay.sandbox.controller.WebhookSender;
import com.testpay.sandbox.controller.response.PaymentState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PaymentCall {

    @Autowired
    private PaymentRepository repository;
    @Autowired
    private WebhookSender sender;

    @Async
    public void paymentCall(PaymentEntity payment) {
        payment.setState(PaymentState.APPROVED);
        repository.save(payment);
        sender.send(payment);
    }
}
