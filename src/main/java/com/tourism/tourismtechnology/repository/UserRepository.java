package com.tourism.tourismtechnology.repository;

import com.tourism.tourismtechnology.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

}