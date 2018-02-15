package com.testpay.sandbox.service;


import java.time.LocalDateTime;

import com.testpay.sandbox.controller.request.PaymentRequest;
import com.testpay.sandbox.controller.response.PaymentResponse;
import com.testpay.sandbox.controller.response.PaymentState;
import com.testpay.sandbox.model.PaymentCall;
import com.testpay.sandbox.model.PaymentEntity;
import com.testpay.sandbox.model.PaymentRepository;
import org.springframework.stereotype.Component;


@Component
public class PaymentService
{
    private final PaymentRepository repository;

    private final PaymentCall call;


    public PaymentService(final PaymentRepository repository, final PaymentCall call)
    {
        this.repository = repository;
        this.call = call;
    }


    public PaymentResponse payment(final PaymentRequest paymentRequest)
    {
        final PaymentEntity paymentEntity = repository.save(new PaymentEntity(paymentRequest));

        call.paymentCall(paymentEntity);

        return new PaymentResponse(paymentEntity.getPaymentId(), LocalDateTime.now().toString(), PaymentState.CREATED);
    }
}
