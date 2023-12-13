package com.avenarl.inventory.service.impl;

import com.avenarl.inventory.model.Product;
import com.avenarl.inventory.repository.ProductRepository;
import com.avenarl.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private Product product;
    public List<Product> listProduct() {
        return productRepository.findAll();
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, Long id) {
        // find first the id
        Product productUpdate = productRepository.findById(id).get();
        return productRepository.save(productUpdate);
    }
}
