package com.smart.inventoryM.Service;

import com.smart.inventoryM.Entity.StockHistory;
import com.smart.inventoryM.Repository.StockHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockHistoryService {
    @Autowired
    StockHistoryRepo stockHistoryRepo;


    public StockHistory create(StockHistory stock) {
        return stockHistoryRepo.save(stock);
    }
}
