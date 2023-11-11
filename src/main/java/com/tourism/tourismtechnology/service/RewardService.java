package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Reward;
import com.tourism.tourismtechnology.model.RewardResponse;
import com.tourism.tourismtechnology.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

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

    public Reward getRewardByUserId(Long id) {
        return rewardRepository.findByUserId(id);
    }

    public RewardResponse getTotalPointsByUserId(Long id) {
        List<Reward> rewards = rewardRepository.findAllByUserId(id);

        long totalPoints = rewards.stream().mapToInt(Reward::getPoints).sum();

        RewardResponse rewardResponse = new RewardResponse();
        rewardResponse.setUserId(id);
        rewardResponse.setPoints(totalPoints);

        return rewardResponse;
    }


}