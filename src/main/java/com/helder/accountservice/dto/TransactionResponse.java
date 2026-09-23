package com.helder.accountservice.dto;

import com.helder.accountservice.model.Account;
import com.helder.accountservice.model.AccountTransaction;
import com.helder.accountservice.model.TransactionStatus;
import com.helder.accountservice.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        String id,
        TransactionType type,
        BigDecimal amount,
        TransactionStatus status,
        AccountResponse account,
        LocalDateTime createdAt
) {
    public static TransactionResponse from(AccountTransaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getStatus(),
                AccountResponse.from(transaction.getAccount()),
                transaction.getCreatedAt()
        );
    }
}