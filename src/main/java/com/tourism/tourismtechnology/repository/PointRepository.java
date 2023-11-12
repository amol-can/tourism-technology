package com.tourism.tourismtechnology.repository;

import com.tourism.tourismtechnology.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    List<Point> findAllByUserId(Long id);

    Optional<Point> findByUserId(Long id);

}
