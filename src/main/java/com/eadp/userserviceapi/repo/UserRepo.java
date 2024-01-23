package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public Optional<User> findUserByUserId(String userId);
}
