package com.avenarl.inventory.controller;

import com.avenarl.inventory.model.Product;
import com.avenarl.inventory.repository.ProductRepository;
import com.avenarl.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.listProduct();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
       productService.deleteById(id);
       return ResponseEntity.noContent().build();
    }

}
