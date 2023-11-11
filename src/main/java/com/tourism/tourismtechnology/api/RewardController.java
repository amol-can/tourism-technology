package com.tourism.tourismtechnology.api;

import com.tourism.tourismtechnology.entity.Reward;
import com.tourism.tourismtechnology.model.RewardResponse;
import com.tourism.tourismtechnology.service.RewardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/user/{id}")
    public RewardResponse getRewardByUserId(@PathVariable Long id) {
        return rewardService.getTotalPointsByUserId(id);
    }
}
