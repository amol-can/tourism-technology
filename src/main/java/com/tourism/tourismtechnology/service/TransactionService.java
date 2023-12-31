package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Point;
import com.tourism.tourismtechnology.entity.Transaction;
import com.tourism.tourismtechnology.mapper.TransactionMapper;
import com.tourism.tourismtechnology.model.dto.TransactionDto;
import com.tourism.tourismtechnology.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        return transactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No transaction id is found"));
    }

    public List<Transaction> getTransactionsByClientId(Long id) {
        return transactionRepository.findByClientId(id);
    }

    public List<Transaction> getTransactionsByBusinessId(Long id) {
        return transactionRepository.findByBusinessId(id);
    }

    public TransactionDto createTransaction(Transaction transaction) {
        // Calculate points based on the transaction amount
        int points = transaction.getAmount().intValue();
        transaction.setPoint(points);
        // Save the Transaction object first
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Create a new Point object and set the points and user
        // if business is not present in points table, create a new point object
        Optional<Point> businessOptionalPoint = pointService.getPointByBusinessId(savedTransaction.getBusiness().getId());

        if (businessOptionalPoint.isPresent()) {
            Point point = businessOptionalPoint.get();
            point.setPoints(point.getPoints() + points);
            pointService.createPoint(point);
        } else {
            Point point = new Point();
            point.setPoints(points);
            point.setUser(savedTransaction.getBusiness());
            point.setDate(new Date());
            pointService.createPoint(point);
        }

        Optional<Point> clientOptionalPoint = pointService.getPointByBusinessId(savedTransaction.getClient().getId());

        if (clientOptionalPoint.isPresent()) {
            Point point = clientOptionalPoint.get();
            point.setPoints(point.getPoints() + points);
            pointService.createPoint(point);
        } else {
            Point point = new Point();
            point.setPoints(points);
            point.setUser(savedTransaction.getClient());
            point.setDate(new Date());
            pointService.createPoint(point);
        }

        return transactionMapper.toDto(savedTransaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
