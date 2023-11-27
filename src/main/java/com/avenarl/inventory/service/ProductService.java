package com.avenarl.inventory.service;

import com.avenarl.inventory.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product addProduct(Product product);
    List<Product> listProduct();
}
