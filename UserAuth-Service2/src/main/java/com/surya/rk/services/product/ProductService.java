package com.surya.rk.services.product;

import java.util.List;

import com.surya.rk.entities.Product;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    }