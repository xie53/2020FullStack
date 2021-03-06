package com.ibm.business.buyer.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.buyer.db.entity.Transactions;

@EnableJpaRepositories
public interface TransactionsRepository extends JpaRepository<Transactions, String> {

	Optional<Transactions> findById(String id);
}
