package com.smart.inventoryM.Service;

import com.smart.inventoryM.Entity.Product;
import com.smart.inventoryM.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepo.findById(id);
    }

    public List<Product> findLowStockProductsByCatotory(String category) {
//        return productRepo.findLowProduct(category);
        return null;
    }
}
