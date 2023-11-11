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
        // Calculate point points based on the transaction amount
        int points = transaction.getAmount().intValue();
        transaction.setPoint(points);
        // Save the Transaction object first
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Create a new Point object and set the points and user
        Point point = new Point();
        point.setPoints(points);
        point.setUser(savedTransaction.getBusiness());
        point.setDate(new Date());

        // Set the saved Transaction object to the point
        point.setTransaction(savedTransaction);

        // Save the Point object
        Point savedPoint = pointService.createPoint(point);

        return transactionMapper.toDto(savedTransaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
