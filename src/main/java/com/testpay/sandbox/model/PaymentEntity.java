package com.testpay.sandbox.model;

import com.testpay.sandbox.controller.request.PaymentIntent;
import com.testpay.sandbox.controller.request.PaymentRequest;
import com.testpay.sandbox.controller.response.PaymentState;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue
    private String paymentId;
    private PaymentIntent intent;
    @Column(name = "notification_url")
    private String notificationUrl;
    @Column(name = "payer_email")
    private String payerEmail;
    @Column(name = "transaction_external_id")
    private String transactionExternalId;
    @Column(name = "transaction_amount_value")
    private String transactionAmountValue;
    @Column(name = "transaction_amount_currency")
    private String transactionAmountCurrency;
    @Column(name = "transaction_description")
    private String transactionDescription;
    @Column(name = "state")
    private PaymentState state;

    public PaymentEntity(PaymentRequest request) {
        intent = request.getIntent();
        notificationUrl = request.getNotificationUrl();
        payerEmail = request.getPayer().getEmail();
        transactionExternalId = request.getTransaction().getExternalId();
        transactionAmountValue = request.getTransaction().getAmount().getValue();
        transactionAmountCurrency = request.getTransaction().getAmount().getCurrency();
        transactionDescription = request.getTransaction().getDescription();
        state = PaymentState.CREATED;
    }
}
