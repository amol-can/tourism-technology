package com.tourism.tourismtechnology.api;

import com.tourism.tourismtechnology.entity.Transaction;
import com.tourism.tourismtechnology.model.TransactionDto;
import com.tourism.tourismtechnology.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionDto> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/client/{id}")
    public List<Transaction> getTransactionsByClientId(@PathVariable Long id) {
        return transactionService.getTransactionsByClientId(id);
    }

    @GetMapping("/business/{id}")
    public List<Transaction> getTransactionsByBusinessId(@PathVariable Long id) {
        return transactionService.getTransactionsByBusinessId(id);
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    public TransactionDto createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}