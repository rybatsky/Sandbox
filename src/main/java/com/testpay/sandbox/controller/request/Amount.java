package com.testpay.sandbox.controller.request;


import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Amount implements Serializable
{
    private static final long serialVersionUID = 3993309914666256746L;

    @JsonProperty("amount")
    private String value;

    @JsonProperty("currency")
    private String currency;


    public String getValue()
    {
        return value;
    }


    void setValue(final String value)
    {
        this.value = value;
    }


    public String getCurrency()
    {
        return currency;
    }


    void setCurrency(final String currency)
    {
        this.currency = currency;
    }


    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Amount amount = (Amount) o;
        return Objects.equals(value, amount.value) &&
                Objects.equals(currency, amount.currency);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(value, currency);
    }


    @Override
    public String toString()
    {
        return "Amount{" +
                "value='" + value + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
