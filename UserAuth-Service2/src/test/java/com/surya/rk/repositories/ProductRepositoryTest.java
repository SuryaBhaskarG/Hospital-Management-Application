package com.surya.rk.repositories;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.surya.rk.entities.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProductTest() {
        Product product = new Product(null, "Laptop", 5, "Gaming Laptop", 1200.0);
        Product saved = productRepository.save(product);

        assertNotNull(saved.getId());
        assertEquals("Laptop", saved.getName());
    }

    @Test
    void findAllProductsTest() {
        Product product1 = new Product(null, "Laptop", 5, "Gaming Laptop", 1200.0);
        Product product2 = new Product(null, "Phone", 10, "Smartphone", 800.0);

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> products = productRepository.findAll();
        assertEquals(2, products.size());
    }
}
