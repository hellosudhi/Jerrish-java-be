package com.smart.inventoryM.Repository;

import com.smart.inventoryM.Entity.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StockHistoryRepo extends JpaRepository<StockHistory,Long> {

    List<StockHistory> findTop5ByProductIdAndQuantityChangedGreaterThanOrderByDateDesc(Long productId, int i);
}
