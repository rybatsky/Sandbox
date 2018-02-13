package com.testpay.sandbox.controller.request;

import lombok.Data;

@Data
public class Transaction {
    private String externalId;
    private Amount amount;
    private String description;
}
