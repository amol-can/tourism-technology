package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Reward;
import com.tourism.tourismtechnology.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;

    @Autowired
    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public Reward createReward(Reward reward) {
        return rewardRepository.save(reward);
    }

    // get reward by user id
    public Reward getRewardByUserId(Long id) {
        return rewardRepository.findByUserId(id);
    }


}