package com.helder.accountservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransactionType {
    @JsonProperty("Deposit")
    DEPOSIT,
    @JsonProperty("Withdraw")
    WITHDRAW;
}