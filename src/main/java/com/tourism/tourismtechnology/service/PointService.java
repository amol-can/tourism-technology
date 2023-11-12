package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.entity.Point;
import com.tourism.tourismtechnology.model.PointsResponse;
import com.tourism.tourismtechnology.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public Optional<Point> getPointByBusinessId(Long userId) {
        return pointRepository.findByUserId(userId);
    }

    public void createPoint(Point point) {
        pointRepository.save(point);
    }

    public PointsResponse getTotalPointsByUserId(Long id) {
        List<Point> points = pointRepository.findAllByUserId(id);

        int totalPoints = points.stream()
                .filter(Objects::nonNull)
                .mapToInt(Point::getPoints)
                .sum();

        PointsResponse pointsResponse = new PointsResponse();
        pointsResponse.setUserId(id);
        pointsResponse.setPoints(totalPoints);

        return pointsResponse;
    }

    public Integer reducePoints(Long businessId, Integer customerPoints, Integer pointsToReduce) {

        int remainingPoints = customerPoints - pointsToReduce;

        Point point = pointRepository.findByUserId(businessId)
                .orElseThrow(() -> new IllegalArgumentException("Business with id " + businessId + " not found"));
        point.setPoints(remainingPoints);
        pointRepository.save(point);

        return remainingPoints;
    }
}