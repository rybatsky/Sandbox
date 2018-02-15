package com.testpay.sandbox.controller.response;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ErrorResponse
{
    @JsonProperty("error")
    private String error;

    @JsonProperty("error_description")
    private String errorDescription;


    public ErrorResponse(final String error, final String errorDescription)
    {
        this.error = error;
        this.errorDescription = errorDescription;
    }


    public String getError()
    {
        return error;
    }


    void setError(final String error)
    {
        this.error = error;
    }


    public String getErrorDescription()
    {
        return errorDescription;
    }


    void setErrorDescription(final String errorDescription)
    {
        this.errorDescription = errorDescription;
    }


    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ErrorResponse that = (ErrorResponse) o;
        return Objects.equals(error, that.error) &&
                Objects.equals(errorDescription, that.errorDescription);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(error, errorDescription);
    }


    @Override
    public String toString()
    {
        return "ErrorResponse{" +
                "error='" + error + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
