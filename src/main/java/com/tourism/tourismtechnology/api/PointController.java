package com.tourism.tourismtechnology.api;

import com.tourism.tourismtechnology.model.PointsResponse;
import com.tourism.tourismtechnology.service.PointService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/points")
public class PointController {

    private final PointService rewardService;

    public PointController(PointService pointService) {
        this.rewardService = pointService;
    }

    @GetMapping("/user/{id}")
    public PointsResponse getPointByUserId(@PathVariable Long id) {
        return rewardService.getTotalPointsByUserId(id);
    }
}
