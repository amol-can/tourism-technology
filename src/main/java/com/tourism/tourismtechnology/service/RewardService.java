package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Reward;
import com.tourism.tourismtechnology.model.RewardRequest;
import com.tourism.tourismtechnology.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;

    @Autowired
    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    public Reward createReward(RewardRequest rewardRequest) {
        Reward reward = new Reward();
        reward.setPoints(rewardRequest.getPoints());
        reward.setTitle(rewardRequest.getTitle());
        reward.setDisabled(rewardRequest.isDisabled());

        return rewardRepository.save(reward);
    }
}
