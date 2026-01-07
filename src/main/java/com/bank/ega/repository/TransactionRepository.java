package com.bank.ega.repository;

import com.bank.ega.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCompteSourceIdOrCompteDestinationId(
            Long sourceId,
            Long destinationId
    );

    List<Transaction> findByDateTransactionBetween(
            LocalDateTime debut,
            LocalDateTime fin
    );
}
