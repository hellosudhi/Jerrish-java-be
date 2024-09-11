package com.smart.inventoryM.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product",uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product Name required")
    private String name;

    private Integer currentStock;

    private Integer minStockThreshold;

    @NotNull(message = "Product Category required")
    private String category;
}
