package com.ibm.business.seller.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.seller.db.entity.Seller;

@EnableJpaRepositories
public interface SellerRepository extends JpaRepository<Seller, String> {
	Optional<Seller> findByUserName(String userName);
}
