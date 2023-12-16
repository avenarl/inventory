package com.avenarl.inventory.controller;

import com.avenarl.inventory.model.Product;
import com.avenarl.inventory.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(2L);
        product.setName("Test Product");
    }

    @Test
    void addProductTest(){
        when(productService.addProduct(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> responseEntity = productController.addProduct(product);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }

    @Test
    void deleteProductTest(){
        ResponseEntity<Void> responseEntity = productController.deleteProduct(2L);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}

