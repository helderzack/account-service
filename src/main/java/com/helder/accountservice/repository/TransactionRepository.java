package com.helder.accountservice.repository;

import com.helder.accountservice.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<AccountTransaction, Long> {
}