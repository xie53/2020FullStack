package com.ibm.business.buyer.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.buyer.db.entity.Seller;

@EnableJpaRepositories
public interface SellerRepository extends JpaRepository<Seller, String> {

	Optional<Seller> findByUserNameAndPassword(String userName, String password);

	Optional<Seller> findByUserName(String userName);
}
