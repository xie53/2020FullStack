package com.ibm.business.seller.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.seller.db.entity.PurchaseHistory;

@EnableJpaRepositories
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, String> {

	Optional<PurchaseHistory> findById(String id);
}
