package com.testpay.sandbox.model;


import com.testpay.sandbox.controller.WebhookSender;
import com.testpay.sandbox.controller.response.PaymentState;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class PaymentCall
{
    private final PaymentRepository repository;

    private final WebhookSender sender;


    public PaymentCall(final PaymentRepository repository, final WebhookSender sender)
    {
        this.repository = repository;
        this.sender = sender;
    }


    @Async
    public void paymentCall(final PaymentEntity payment)
    {
        payment.setState(PaymentState.APPROVED);
        repository.save(payment);
        sender.send(payment);
    }
}
