package com.smart.inventoryM.Service;

import com.smart.inventoryM.Dto.ProductDto;
import com.smart.inventoryM.Entity.Product;
import com.smart.inventoryM.Entity.StockHistory;
import com.smart.inventoryM.Repository.ProductRepo;
import com.smart.inventoryM.Repository.StockHistoryRepo;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    StockHistoryRepo stockHistoryRepo;

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepo.findById(id);
    }


    public List<Product> findLowStockProductsByCategory(String category) {
        int minStockThreshold = 5;
        if(!category.isEmpty()){
            return productRepo.findByCurrentStockLessThanEqualAndCategory(minStockThreshold,category);
        }
        return productRepo.findByCurrentStockLessThanEqual(minStockThreshold);
    }

    @SneakyThrows
    public Product updateStock(Long id, @Valid ProductDto productDto)  {
        Product product = productRepo.findById(id).orElseThrow(() ->   new Exception("Product not found"));
        product.setCurrentStock(product.getCurrentStock() + productDto.getQuantityChanged());

        StockHistory stockHistory = new StockHistory();
        stockHistory.setProductId(id);
        stockHistory.setQuantityChanged(productDto.getQuantityChanged());
        stockHistory.setDate(LocalDate.now());
        stockHistoryRepo.save(stockHistory);
        return productRepo.save(product);
    }

    public  int getRestockSuggestion(Long productId){
        List<StockHistory> stockHistories = stockHistoryRepo.findTop5ByProductIdAndQuantityChangedGreaterThanOrderByDateDesc(productId,0);
        return stockHistories.stream().mapToInt(StockHistory::getQuantityChanged).sum() / Math.max(stockHistories.size(), 1);
    }

}
