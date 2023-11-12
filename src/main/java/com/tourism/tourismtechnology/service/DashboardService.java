package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.User;
import com.tourism.tourismtechnology.model.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final PointService pointService;
    private final TransactionService transactionService;
    private final AuthService authService;

    @Autowired
    public DashboardService(PointService pointService, TransactionService transactionService, AuthService authService) {
        this.pointService = pointService;
        this.transactionService = transactionService;
        this.authService = authService;
    }

    public Dashboard getDashboardConfiguration(Long userId) {
        Dashboard dashboard = new Dashboard();
        dashboard.setTotalPoints(pointService.getTotalPointsByUserId(userId).getPoints());

        User user = authService.getUserById(userId);
        if (user.getRole() == User.ROLE.CUSTOMER) {
            dashboard.setNrOfTransactions((long) transactionService.getTransactionsByClientId(userId).size());
        } else {
            dashboard.setNrOfTransactions((long) transactionService.getTransactionsByBusinessId(userId).size());
        }
        return dashboard;
    }
}
