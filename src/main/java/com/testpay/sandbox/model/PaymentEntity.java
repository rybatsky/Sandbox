package com.testpay.sandbox.model;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.testpay.sandbox.controller.request.PaymentIntent;
import com.testpay.sandbox.controller.request.PaymentRequest;
import com.testpay.sandbox.controller.response.PaymentState;


@Entity
@Table(name = "payment")
public class PaymentEntity
{
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


    public PaymentEntity()
    {
    }


    public PaymentEntity(final PaymentRequest request)
    {
        intent = request.getIntent();
        notificationUrl = request.getNotificationUrl();
        payerEmail = request.getPayer().getEmail();
        transactionExternalId = request.getTransaction().getExternalId();
        transactionAmountValue = request.getTransaction().getAmount().getValue();
        transactionAmountCurrency = request.getTransaction().getAmount().getCurrency();
        transactionDescription = request.getTransaction().getDescription();
        state = PaymentState.CREATED;
    }


    public String getPaymentId()
    {
        return paymentId;
    }


    void setPaymentId(final String paymentId)
    {
        this.paymentId = paymentId;
    }


    public PaymentIntent getIntent()
    {
        return intent;
    }


    void setIntent(final PaymentIntent intent)
    {
        this.intent = intent;
    }


    public String getNotificationUrl()
    {
        return notificationUrl;
    }


    void setNotificationUrl(final String notificationUrl)
    {
        this.notificationUrl = notificationUrl;
    }


    public String getPayerEmail()
    {
        return payerEmail;
    }


    public void setPayerEmail(final String payerEmail)
    {
        this.payerEmail = payerEmail;
    }


    public String getTransactionExternalId()
    {
        return transactionExternalId;
    }


    void setTransactionExternalId(final String transactionExternalId)
    {
        this.transactionExternalId = transactionExternalId;
    }


    public String getTransactionAmountValue()
    {
        return transactionAmountValue;
    }


    void setTransactionAmountValue(final String transactionAmountValue)
    {
        this.transactionAmountValue = transactionAmountValue;
    }


    public String getTransactionAmountCurrency()
    {
        return transactionAmountCurrency;
    }


    void setTransactionAmountCurrency(final String transactionAmountCurrency)
    {
        this.transactionAmountCurrency = transactionAmountCurrency;
    }


    public String getTransactionDescription()
    {
        return transactionDescription;
    }


    void setTransactionDescription(final String transactionDescription)
    {
        this.transactionDescription = transactionDescription;
    }


    public PaymentState getState()
    {
        return state;
    }


    void setState(final PaymentState state)
    {
        this.state = state;
    }


    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(paymentId, that.paymentId) &&
                intent == that.intent &&
                Objects.equals(notificationUrl, that.notificationUrl) &&
                Objects.equals(payerEmail, that.payerEmail) &&
                Objects.equals(transactionExternalId, that.transactionExternalId) &&
                Objects.equals(transactionAmountValue, that.transactionAmountValue) &&
                Objects.equals(transactionAmountCurrency, that.transactionAmountCurrency) &&
                Objects.equals(transactionDescription, that.transactionDescription) &&
                state == that.state;
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(paymentId, intent, notificationUrl, payerEmail, transactionExternalId,
                transactionAmountValue, transactionAmountCurrency, transactionDescription, state);
    }


    @Override
    public String toString()
    {
        return "PaymentEntity{" +
                "paymentId='" + paymentId + '\'' +
                ", intent=" + intent +
                ", notificationUrl='" + notificationUrl + '\'' +
                ", payerEmail='" + payerEmail + '\'' +
                ", transactionExternalId='" + transactionExternalId + '\'' +
                ", transactionAmountValue='" + transactionAmountValue + '\'' +
                ", transactionAmountCurrency='" + transactionAmountCurrency + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", state=" + state +
                '}';
    }
}
