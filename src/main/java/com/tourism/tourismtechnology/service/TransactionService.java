package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Point;
import com.tourism.tourismtechnology.entity.Transaction;
import com.tourism.tourismtechnology.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final PointService rewardService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, PointService rewardService) {
        this.transactionRepository = transactionRepository;
        this.rewardService = rewardService;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getTransactionsByClientId(Long id) {
        return transactionRepository.findByClientId(id);
    }

    public List<Transaction> getTransactionsByBusinessId(Long id) {
        return transactionRepository.findByBusinessId(id);
    }

    public Transaction createTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Calculate reward points based on the transaction amount
        int points = savedTransaction.getAmount().intValue();

        // Create a new Reward object and set the points and transaction
        Point reward = new Point();
        reward.setPoints(points);
        reward.setTransaction(savedTransaction);
        reward.setUser(savedTransaction.getBusiness());
        reward.setDate(new Date());

        rewardService.createPoint(reward);

        return savedTransaction;
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
