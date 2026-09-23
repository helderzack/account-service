package com.helder.accountservice.dto;

import com.helder.accountservice.model.TransactionStatus;
import com.helder.accountservice.model.TransactionType;

import java.math.BigDecimal;

public record TransactionRequest(
        String id,
        TransactionType type,
        BigDecimal amount,
        TransactionStatus status,
        Long accountId) {
}