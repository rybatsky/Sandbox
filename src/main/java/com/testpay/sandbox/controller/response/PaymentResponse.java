package com.testpay.sandbox.controller.response;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PaymentResponse
{
    @JsonProperty("id")
    private String id;

    @JsonProperty("create_time")
    private String createTime;

    @JsonProperty("state")
    private PaymentState state;


    public PaymentResponse(final String id, final String createTime, final PaymentState state)
    {
        this.id = id;
        this.createTime = createTime;
        this.state = state;
    }


    public String getId()
    {
        return id;
    }


    void setId(final String id)
    {
        this.id = id;
    }


    public String getCreateTime()
    {
        return createTime;
    }


    void setCreateTime(final String createTime)
    {
        this.createTime = createTime;
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
        final PaymentResponse that = (PaymentResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createTime, that.createTime) &&
                state == that.state;
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, createTime, state);
    }


    @Override
    public String toString()
    {
        return "PaymentResponse{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state=" + state +
                '}';
    }
}
