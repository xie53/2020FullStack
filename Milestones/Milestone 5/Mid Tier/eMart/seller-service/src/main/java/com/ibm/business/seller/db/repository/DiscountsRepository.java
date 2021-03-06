package com.ibm.business.seller.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.seller.db.entity.Discounts;

@EnableJpaRepositories
public interface DiscountsRepository extends JpaRepository<Discounts, String> {

	Optional<Discounts> findById(String id);
}
