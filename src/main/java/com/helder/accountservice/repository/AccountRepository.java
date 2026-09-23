package com.helder.accountservice.repository;

import com.helder.accountservice.model.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @EntityGraph(attributePaths = {"client"})
    List<Account> findAll();

    @EntityGraph(attributePaths = {"client"})
    Optional<Account> findById(Long id);

}