package com.smart.inventoryM.Controller;

import com.smart.inventoryM.Dto.ProductDto;
import com.smart.inventoryM.Entity.Product;
import com.smart.inventoryM.Service.ProductService;
import com.smart.inventoryM.Service.StockHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController("")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    StockHistoryService stockHistoryService;

    @PostMapping("/api/products")
    public ResponseEntity<Product> addNewProduct(@Valid @RequestBody() Product product) {
       final Product productResponse=  productService.createProduct(product);
        return ResponseEntity.ok(productResponse);
    }
    @PutMapping("/api/products/{id}/stock")
    public ResponseEntity<?> updateProductById( @PathVariable("id") Long id,@Valid @RequestBody() ProductDto productDto){
        Product updatedProduct = productService.updateStock(id,productDto);
        return ResponseEntity.ok(updatedProduct);
    }
    @GetMapping("/api/products/low-stock")
    public ResponseEntity<?> getLowStock(@RequestParam( value = "category",required = false) String category){
        final List<Product> lowStock = productService.findLowStockProductsByCategory(category);
        return ResponseEntity.ok(lowStock);
    }
    @GetMapping("/api/products/{id}/restock-suggestions")
    public ResponseEntity<?> getStockSuggestions(@PathVariable("id") Long Id){
        int suggestedAmount = productService.getRestockSuggestion(Id);
        Map<String,Object> reponseMap = new HashMap<>();
        reponseMap.put("ProductId",Id);
        reponseMap.put("SuggestedRestockAmount",suggestedAmount);
        return ResponseEntity.ok(reponseMap);
    }
}
