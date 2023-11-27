package com.avenarl.inventory.service;

import com.avenarl.inventory.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product addProduct(Product product);
}
