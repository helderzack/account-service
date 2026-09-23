package com.helder.accountservice.dto;

import com.helder.accountservice.model.Account;

import java.math.BigDecimal;

public record AccountResponse(
        Long id,
        String account,
        String agency,
        BigDecimal accountBalance,
        ClientResponse client) {
    public static AccountResponse from(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getAccount(),
                account.getAgency(),
                account.getAccountBalance(),
                ClientResponse.from(account.getClient())
        );
    }
}
