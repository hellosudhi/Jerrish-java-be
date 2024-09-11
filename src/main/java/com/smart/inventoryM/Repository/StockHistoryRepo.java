package com.smart.inventoryM.Repository;

import com.smart.inventoryM.Entity.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockHistoryRepo extends JpaRepository<StockHistory,Long> {
}
