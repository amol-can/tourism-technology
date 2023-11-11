package com.tourism.tourismtechnology.repository;

import com.tourism.tourismtechnology.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward, Long> {
    Reward findByUserId(Long id);

    List<Reward> findAllByUserId(Long id);
}
