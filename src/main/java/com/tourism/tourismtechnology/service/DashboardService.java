package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.model.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final PointService pointService;
    private final TransactionService transactionService;

    @Autowired
    public DashboardService(PointService pointService, TransactionService transactionService) {
        this.pointService = pointService;
        this.transactionService = transactionService;
    }

    public Dashboard getDashboardConfiguration(Long userId) {
        Dashboard dashboard = new Dashboard();
        dashboard.setTotalPoints(pointService.getTotalPointsByUserId(userId).getPoints());
        dashboard.setNrOfTransactions((long) transactionService.getTransactionsByBusinessId(userId).size());
        return dashboard;
    }
}
