package com.smart.inventoryM.Repository;

import com.smart.inventoryM.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByCurrentStockLessThanEqualAndCategory( int minStockThreshold,String category);

    List<Product> findByCurrentStockLessThanEqual(int minStockThreshold);
}
