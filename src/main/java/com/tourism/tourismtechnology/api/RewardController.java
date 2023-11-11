package com.tourism.tourismtechnology.api;

import com.tourism.tourismtechnology.entity.Reward;
import com.tourism.tourismtechnology.model.RewardRequest;
import com.tourism.tourismtechnology.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public List<Reward> getAllRewards() {
        return rewardService.getAllRewards();
    }

    @PostMapping
    public Reward createReward(@RequestBody RewardRequest rewardRequest) {
        return rewardService.createReward(rewardRequest);
    }

}
