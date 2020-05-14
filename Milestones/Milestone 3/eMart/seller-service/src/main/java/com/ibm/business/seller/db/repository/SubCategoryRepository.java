package com.ibm.business.seller.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.seller.db.entity.SubCategory;

@EnableJpaRepositories
public interface SubCategoryRepository extends JpaRepository<SubCategory, String> {

	Optional<SubCategory> findBySubcategoryName(String subcategoryName);
}
