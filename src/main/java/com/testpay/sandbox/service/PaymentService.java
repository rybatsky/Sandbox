package com.testpay.sandbox.service;

import com.testpay.sandbox.controller.request.PaymentRequest;
import com.testpay.sandbox.controller.response.PaymentResponse;
import com.testpay.sandbox.controller.response.PaymentState;
import com.testpay.sandbox.model.PaymentCall;
import com.testpay.sandbox.model.PaymentEntity;
import com.testpay.sandbox.model.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentService {

    @Autowired
    private PaymentRepository repository;
    @Autowired
    private PaymentCall call;

    public PaymentResponse payment(PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = repository.save(new PaymentEntity(paymentRequest));
        call.paymentCall(paymentEntity);
        return new PaymentResponse(paymentEntity.getPaymentId(),
                LocalDateTime.now().toString(),
                PaymentState.CREATED);
    }
}
