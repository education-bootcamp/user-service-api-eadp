package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.ShippingAddress;
import com.eadp.userserviceapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
public interface ShippingRepo extends JpaRepository<ShippingAddress, Long> {
    public Optional<ShippingAddress> findShippingAddressByUser(User user);
}
