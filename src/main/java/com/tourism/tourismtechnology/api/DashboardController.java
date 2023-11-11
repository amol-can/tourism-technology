package com.tourism.tourismtechnology.api;

import com.tourism.tourismtechnology.model.Dashboard;
import com.tourism.tourismtechnology.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/{userId}")
    public Dashboard getDashboardConfiguration(@PathVariable Long userId) {
        return dashboardService.getDashboardConfiguration(userId);
    }

}
