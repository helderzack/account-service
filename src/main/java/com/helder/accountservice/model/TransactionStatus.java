package com.helder.accountservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransactionStatus {
    @JsonProperty("Pending")
    PENDING,
    @JsonProperty("Approved")
    APPROVED,
    @JsonProperty("Failed")
    FAILED;
}