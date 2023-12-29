package com.avenarl.inventory.service.impl;

import com.avenarl.inventory.model.Product;
import com.avenarl.inventory.repository.ProductRepository;
import com.avenarl.inventory.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if(existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            if(product.getName() != null)
                existingProduct.setName(product.getName());
            if(product.getPrice() != null)
                existingProduct.setPrice((product.getPrice()));
            if(product.getId() != null)
                existingProduct.setId(product.getId());
            return productRepository.save(existingProduct);
        } else {
            throw new EntityNotFoundException(("Product with ID " + id + " not found."));
        }
    }
}
