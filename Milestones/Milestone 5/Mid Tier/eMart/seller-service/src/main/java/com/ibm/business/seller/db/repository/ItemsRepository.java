package com.ibm.business.seller.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.seller.db.entity.Items;

@EnableJpaRepositories
public interface ItemsRepository extends JpaRepository<Items, String> {
	
	Optional<Items> findById(String id);

	Optional<Items> findByItemName(String itemName);
}
