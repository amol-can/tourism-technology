package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Transaction;
import com.tourism.tourismtechnology.mapper.TransactionMapper;
import com.tourism.tourismtechnology.model.dto.TransactionDto;
import com.tourism.tourismtechnology.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionMapper transactionMapper;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void getAllTransactionsShouldReturnAllTransactions() {
        List<Transaction> transactions = List.of(
                new Transaction(), new Transaction(), new Transaction()
        );

        when(transactionRepository.findAll()).thenReturn(transactions);

        List<TransactionDto> actual = transactionService.getAllTransactions();

        assertEquals(transactions.size(), actual.size());

        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    void getTransactionByIdShouldReturnTransactionWhenExists() {
        Long transactionId = 1L;
        Transaction transaction = new Transaction();

        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(transaction));

        Transaction actual = transactionService.getTransactionById(transactionId);

        assertNotNull(actual);
        assertEquals(transaction, actual);

        verify(transactionRepository, times(1)).findById(transactionId);
    }

    @Test
    void getTransactionByIdShouldReturnNullWhenNotExists() {
        Long transactionId = 1L;
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,
                () -> transactionService.getTransactionById(transactionId)
        );
    }

    @Test
    void getTransactionsByClientIdShouldReturnTransactions() {
        Long clientId = 1L;
        List<Transaction> transactions = Arrays.asList(
                new Transaction(), new Transaction(), new Transaction()
        );

        when(transactionRepository.findByClientId(clientId)).thenReturn(transactions);

        List<Transaction> actual = transactionService.getTransactionsByClientId(clientId);

        assertEquals(transactions.size(), actual.size());

        verify(transactionRepository, times(1)).findByClientId(clientId);
    }

}
