package com.surya.rk.services.product;


import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.surya.rk.entities.Product;
import com.surya.rk.repositories.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void saveProductTest() {
        Product product = new Product(null, "Laptop", 5, "Gaming Laptop", 1200.0);
        Product saved = new Product(1L, "Laptop", 5, "Gaming Laptop", 1200.0);

        when(productRepository.save(product)).thenReturn(saved);

        Product result = productService.saveProduct(product);
        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("Laptop", result.getName());
    }

    @Test
    void getAllProductsTest() {
        List<Product> products = List.of(
                new Product(1L, "Laptop", 5, "Gaming Laptop", 1200.0)
        );
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void getProductByIdTest() {
        Product product = new Product(1L, "Laptop", 5, "Gaming Laptop", 1200.0);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1L);
        Assertions.assertEquals("Laptop", result.getName());
    }

    @Test
    void updateProductTest() {
        Product existing = new Product(1L, "Old Laptop", 3, "Old", 800.0);
        Product updated = new Product(1L, "New Laptop", 5, "Better", 1500.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(productRepository.save(existing)).thenReturn(updated);

        Product result = productService.updateProduct(1L, updated);

        Assertions.assertEquals("New Laptop", result.getName());
        Assertions.assertEquals(1500.0, result.getPrice());
    }

    @Test
    void deleteProductTest() {
        Product product = new Product(1L, "Laptop", 5, "Gaming Laptop", 1200.0);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        doNothing().when(productRepository).delete(product);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).delete(product);
    }
}
