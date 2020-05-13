package com.ibm.business.seller.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.seller.db.entity.Buyer;

@EnableJpaRepositories
public interface BuyerRepository extends JpaRepository<Buyer, String> {
	Optional<Buyer> findByUserName(String userName);
}
