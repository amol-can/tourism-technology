package com.tourism.tourismtechnology.repository;

import com.tourism.tourismtechnology.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByClientId(Long id);

    List<Transaction> findByBusinessId(Long id);
}
