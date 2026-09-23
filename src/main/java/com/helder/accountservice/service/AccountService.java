package com.helder.accountservice.service;

import com.helder.accountservice.dto.AccountResponse;
import com.helder.accountservice.dto.TransactionRequest;
import com.helder.accountservice.dto.TransactionResponse;
import com.helder.accountservice.model.Account;
import com.helder.accountservice.model.AccountTransaction;
import com.helder.accountservice.repository.AccountRepository;
import com.helder.accountservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional(readOnly = true)
    public List<AccountResponse> getAccounts() {
        return accountRepository
                .findAll()
                .stream()
                .map(AccountResponse::from)
                .toList();
    }

    @Transactional
    public String registerTransaction(TransactionRequest transactionRequest) throws AccountNotFoundException {
        Optional<Account> transaction = accountRepository.findById(transactionRequest.accountId());
        if (transaction.isPresent()) {
            AccountTransaction accountTransaction = new AccountTransaction(
                    transactionRequest.type(),
                    transactionRequest.amount(),
                    transactionRequest.status(),
                    transaction.get());
            transactionRepository.save(accountTransaction);
        } else {
            throw new AccountNotFoundException("Account not found");
        }
        return "Tudo certo";
    }

    public List<TransactionResponse> getTransactions() {
        return transactionRepository
                .findAll()
                .stream()
                .map(TransactionResponse::from).toList();
    }
}