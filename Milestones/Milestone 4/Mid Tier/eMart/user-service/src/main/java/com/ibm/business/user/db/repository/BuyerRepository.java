package com.ibm.business.user.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.user.db.entity.Buyer;

@EnableJpaRepositories
public interface BuyerRepository extends JpaRepository<Buyer, String> {

	Optional<Buyer> findByUserNameAndPassword(String userName, String password);

	Optional<Buyer> findByUserName(String userName);
}
