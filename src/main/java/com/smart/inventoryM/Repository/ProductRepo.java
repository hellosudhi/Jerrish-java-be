package com.smart.inventoryM.Repository;

import com.smart.inventoryM.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,Long> {
//    @Modifying
//    @Query("SELECT * FROM product where currentStock <= minStockThreshold or category=:category")
//    List<Product> findByCategory(String category);
}
