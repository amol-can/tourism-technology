package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Point;
import com.tourism.tourismtechnology.model.PointsResponse;
import com.tourism.tourismtechnology.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public Point createPoint(Point point) {
        return pointRepository.save(point);
    }

    public Point getRewardByUserId(Long id) {
        return pointRepository.findByUserId(id);
    }

    public PointsResponse getTotalPointsByUserId(Long id) {
        List<Point> rewards = pointRepository.findAllByUserId(id);

        long totalPoints = rewards.stream().mapToInt(Point::getPoints).sum();

        PointsResponse rewardResponse = new PointsResponse();
        rewardResponse.setUserId(id);
        rewardResponse.setPoints(totalPoints);

        return rewardResponse;
    }


}