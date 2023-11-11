package com.tourism.tourismtechnology.repository;

import com.tourism.tourismtechnology.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {
    Point findByUserId(Long id);

    List<Point> findAllByUserId(Long id);
}
