package com.smart.inventoryM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.smart.inventoryM"})
public class InventoryMApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMApplication.class, args);
	}

}
