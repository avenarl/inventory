package com.avenarl.inventory.service;

import com.avenarl.inventory.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> listProduct();
    public void deleteById(Long id);

    public Product addProduct(Product product);

    Product updateProduct(Product product, Long id);
}
