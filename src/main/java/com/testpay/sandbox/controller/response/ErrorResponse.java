package com.testpay.sandbox.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String error;
    @JsonProperty("error_description")
    private String errorDescription;
}
