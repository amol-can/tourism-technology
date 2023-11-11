package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Point;
import com.tourism.tourismtechnology.entity.Transaction;
import com.tourism.tourismtechnology.mapper.TransactionMapper;
import com.tourism.tourismtechnology.model.TransactionDto;
import com.tourism.tourismtechnology.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final PointService pointService;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, PointService pointService, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.pointService = pointService;
        this.transactionMapper = transactionMapper;
    }

    public List<TransactionDto> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionMapper::toDto)
                .toList();
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

    public TransactionDto createTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Calculate reward points based on the transaction amount
        int points = savedTransaction.getAmount().intValue();

        // Create a new Reward object and set the points and transaction
        Point reward = new Point();
        reward.setPoints(points);
        reward.setTransaction(savedTransaction);
        reward.setUser(savedTransaction.getBusiness());
        reward.setDate(new Date());

        pointService.createPoint(reward);

        return transactionMapper.toDto(savedTransaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
