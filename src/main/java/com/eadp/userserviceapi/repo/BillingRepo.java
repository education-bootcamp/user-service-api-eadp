package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepo extends JpaRepository<BillingAddress, Long> {
}
