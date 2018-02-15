package com.testpay.sandbox.controller.request;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WebhookRequest
{
    @JsonProperty("currency")
    private String currency;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("id")
    private String id;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("sha2sig")
    private String sha2sig;


    public WebhookRequest(final String currency, final String amount, final String id, final String externalId,
            final String status, final String sha2sig)
    {
        this.currency = currency;
        this.amount = amount;
        this.id = id;
        this.externalId = externalId;
        this.status = status;
        this.sha2sig = sha2sig;
    }


    public String getCurrency()
    {
        return currency;
    }


    void setCurrency(final String currency)
    {
        this.currency = currency;
    }


    public String getAmount()
    {
        return amount;
    }


    void setAmount(final String amount)
    {
        this.amount = amount;
    }


    public String getId()
    {
        return id;
    }


    void setId(final String id)
    {
        this.id = id;
    }


    public String getExternalId()
    {
        return externalId;
    }


    void setExternalId(final String externalId)
    {
        this.externalId = externalId;
    }


    public String getStatus()
    {
        return status;
    }


    void setStatus(final String status)
    {
        this.status = status;
    }


    public String getSha2sig()
    {
        return sha2sig;
    }


    void setSha2sig(final String sha2sig)
    {
        this.sha2sig = sha2sig;
    }


    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WebhookRequest that = (WebhookRequest) o;
        return Objects.equals(currency, that.currency) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(id, that.id) &&
                Objects.equals(externalId, that.externalId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(sha2sig, that.sha2sig);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(currency, amount, id, externalId, status, sha2sig);
    }


    @Override
    public String toString()
    {
        return "WebhookRequest{" +
                "currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", id='" + id + '\'' +
                ", externalId='" + externalId + '\'' +
                ", status='" + status + '\'' +
                ", sha2sig='" + sha2sig + '\'' +
                '}';
    }
}
