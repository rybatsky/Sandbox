package com.testpay.sandbox.controller.request;


import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PaymentRequest implements Serializable
{
    private static final long serialVersionUID = 1509689736121575945L;

    @JsonProperty("intent")
    private PaymentIntent intent;

    @JsonProperty("notification_url")
    private String notificationUrl;

    @JsonProperty("payer")
    private Payer payer;

    @JsonProperty("transaction")
    private Transaction transaction;


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


    public Payer getPayer()
    {
        return payer;
    }


    void setPayer(final Payer payer)
    {
        this.payer = payer;
    }


    public Transaction getTransaction()
    {
        return transaction;
    }


    void setTransaction(final Transaction transaction)
    {
        this.transaction = transaction;
    }


    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PaymentRequest that = (PaymentRequest) o;
        return intent == that.intent &&
                Objects.equals(notificationUrl, that.notificationUrl) &&
                Objects.equals(payer, that.payer) &&
                Objects.equals(transaction, that.transaction);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(intent, notificationUrl, payer, transaction);
    }


    @Override
    public String toString()
    {
        return "PaymentRequest{" +
                "intent=" + intent +
                ", notificationUrl='" + notificationUrl + '\'' +
                ", payer=" + payer +
                ", transaction=" + transaction +
                '}';
    }
}
