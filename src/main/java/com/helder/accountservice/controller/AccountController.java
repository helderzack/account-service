package com.helder.accountservice.controller;

import com.helder.accountservice.dto.AccountResponse;
import com.helder.accountservice.dto.TransactionRequest;
import com.helder.accountservice.dto.TransactionResponse;
import com.helder.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAccounts() {
        return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> registerTransaction(@RequestBody TransactionRequest transaction) throws AccountNotFoundException {
        return new ResponseEntity<>(accountService.registerTransaction(transaction), HttpStatus.CREATED);
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionResponse>> getTransactions() {
        return new ResponseEntity<>(accountService.getTransactions(), HttpStatus.OK);
    }
}