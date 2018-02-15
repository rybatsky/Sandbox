package com.testpay.sandbox.controller.request;


import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payer implements Serializable
{
    private static final long serialVersionUID = -2356821758338357523L;

    @JsonProperty("email")
    private String email;


    public String getEmail()
    {
        return email;
    }


    void setEmail(final String email)
    {
        this.email = email;
    }


    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Payer payer = (Payer) o;
        return Objects.equals(email, payer.email);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(email);
    }


    @Override
    public String toString()
    {
        return "Payer{" +
                "email='" + email + '\'' +
                '}';
    }
}
