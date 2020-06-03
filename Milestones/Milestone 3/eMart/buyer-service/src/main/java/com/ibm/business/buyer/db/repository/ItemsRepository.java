package com.ibm.business.buyer.db.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.ibm.business.buyer.db.entity.Items;

@EnableJpaRepositories
public interface ItemsRepository extends JpaRepository<Items, String> {
	
	Optional<Items> findById(String id);

	Optional<Items> findByItemName(String itemName);

	@Query(value = "SELECT item FROM Items AS item WHERE "
//					+ "IF(:itemName is not null, item.itemName LIKE CONCAT('%',:itemName,'%'), 1 = 1)"
					+ " item.itemName LIKE CONCAT('%',:itemName,'%')"
//					+ " AND IF (:category is not null, item.categoryId = :category , 1 = 1) "
					+ " AND item.categoryId = :category"
					+ " AND item.subcategoryId = :subCategory"
					+ " AND item.price >= :startPrice"
					+ " AND item.price <= :endPrice")
	List<Items> findItemInfo(
			@Param("itemName") String itemName,
			@Param("category") String category,
			@Param("subCategory") String subCategory,
			@Param("startPrice") Double startPrice,
			@Param("endPrice") Double endPrice);
//	Optional<Items> findItemInfo(
//			@Param("itemName") String itemName,
//			@Param("category") String category,
//			@Param("subCategory") String subCategory,
//			@Param("startPrice") Double startPrice,
//			@Param("endPrice") Double endPrice);
}
