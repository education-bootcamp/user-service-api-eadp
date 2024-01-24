package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface ShippingRepo extends JpaRepository<ShippingAddress, Long> {
}
