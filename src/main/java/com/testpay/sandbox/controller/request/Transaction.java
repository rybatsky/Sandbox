package com.testpay.sandbox.controller.request;


import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Transaction implements Serializable
{
    private static final long serialVersionUID = 3642430155503534044L;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("amount")
    private Amount amount;

    @JsonProperty("description")
    private String description;


    public String getExternalId()
    {
        return externalId;
    }


    void setExternalId(final String externalId)
    {
        this.externalId = externalId;
    }


    public Amount getAmount()
    {
        return amount;
    }


    void setAmount(final Amount amount)
    {
        this.amount = amount;
    }


    public String getDescription()
    {
        return description;
    }


    void setDescription(final String description)
    {
        this.description = description;
    }


    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Transaction that = (Transaction) o;
        return Objects.equals(externalId, that.externalId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(description, that.description);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(externalId, amount, description);
    }


    @Override
    public String toString()
    {
        return "Transaction{" +
                "externalId='" + externalId + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
