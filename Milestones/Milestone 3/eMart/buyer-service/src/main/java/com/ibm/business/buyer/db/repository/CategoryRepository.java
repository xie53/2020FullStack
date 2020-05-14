package com.ibm.business.buyer.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.buyer.db.entity.Category;
import com.ibm.business.buyer.db.entity.Seller;

@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Seller, String> {

	Optional<Category> findByCategory_name(String category_name);
}
