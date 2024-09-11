package com.smart.inventoryM.Controller;

import com.smart.inventoryM.Dto.ProductDto;
import com.smart.inventoryM.Entity.Product;
import com.smart.inventoryM.Entity.StockHistory;
import com.smart.inventoryM.Service.ProductService;
import com.smart.inventoryM.Service.StockHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> updateProductById( @PathVariable("id") Long id,@RequestBody()ProductDto productDto){
        final Optional<Product> promise = productService.findProductById(id);
        StockHistory stock = new StockHistory();
        if(promise.isPresent()){
            stock.setProductId(id);
            stock.setQuantityChanged(productDto.getQuantityChanged());
            stock.setDate(new Date());
            stockHistoryService.create(stock);
        }
        return ResponseEntity.ok(stock);
    }
    @GetMapping("/api/products/low-stock")
    public ResponseEntity<?> getLowStock(@RequestParam("category") String category){
        final List<Product> lowStock = productService.findLowStockProductsByCatotory( category);
        return ResponseEntity.ok(lowStock);
    }
}
