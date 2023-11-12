package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Point;
import com.tourism.tourismtechnology.entity.Reward;
import com.tourism.tourismtechnology.model.ClaimRequest;
import com.tourism.tourismtechnology.model.ClaimResponse;
import com.tourism.tourismtechnology.model.PointsResponse;
import com.tourism.tourismtechnology.model.RewardRequest;
import com.tourism.tourismtechnology.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;
    private final PointService pointService;

    @Autowired
    public RewardService(RewardRepository rewardRepository, PointService pointService) {
        this.rewardRepository = rewardRepository;
        this.pointService = pointService;
    }

    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    public List<Reward> getRewardByBusinessId(Long id) {
        Optional<Point> pointOptional = pointService.getPointByBusinessId(id);
        int points = pointOptional.map(Point::getPoints).orElse(0);

        List<Reward> rewards = rewardRepository.findAll();
        rewards.forEach(reward -> {
            if (points < reward.getPoints()) {
                reward.setDisabled(true);
            }
        });

        return rewards;
    }

    public Reward createReward(RewardRequest rewardRequest) {
        Reward reward = new Reward();
        reward.setPoints(rewardRequest.getPoints());
        reward.setTitle(rewardRequest.getTitle());
        reward.setDisabled(rewardRequest.isDisabled());

        return rewardRepository.save(reward);
    }

    public ClaimResponse claimReward(ClaimRequest claimRequest) {
        PointsResponse pointsResponse = pointService.getTotalPointsByUserId(claimRequest.getBusinessId());

        Optional<Reward> optionalReward = rewardRepository.findById(claimRequest.getRewardId());
        if (optionalReward.isEmpty()) {
            throw new IllegalArgumentException("Reward not found");
        }

        Integer rewardPoints = optionalReward.get().getPoints();
        Integer customerPoints = pointsResponse.getPoints();
        if (customerPoints < rewardPoints) {
            throw new IllegalArgumentException("Not enough points");
        }

        Integer remainingPoints = pointService.reducePoints(claimRequest.getBusinessId(), customerPoints, rewardPoints);

        ClaimResponse claimResponse = new ClaimResponse();
        claimResponse.setClaimMessage("Reward claimed successfully, remaining points: " + remainingPoints);
        claimResponse.setClaimed(true);
        return claimResponse;
    }
}
