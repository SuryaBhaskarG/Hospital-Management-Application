package com.surya.rk.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surya.rk.entities.Product;
import com.surya.rk.services.product.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = {ProductController.class})
@Import(org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration.class)
@AutoConfigureMockMvc(addFilters = false) // ✅ disables Spring Security for tests
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveProductTest() throws Exception {
        Product product = new Product(1L, "Laptop", 5, "Gaming Laptop", 1200.0);
        Mockito.when(productService.saveProduct(Mockito.any())).thenReturn(product);

        mockMvc.perform(post("/api/products")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void getAllProductsTest() throws Exception {
        List<Product> products = List.of(
                new Product(1L, "Laptop", 5, "Gaming Laptop", 1200.0),
                new Product(2L, "Phone", 10, "Smartphone", 800.0)
        );
        Mockito.when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getProductByIdTest() throws Exception {
        Product product = new Product(1L, "Laptop", 5, "Gaming Laptop", 1200.0);
        Mockito.when(productService.getProductById(1L)).thenReturn(product);

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void updateProductTest() throws Exception {
        Product updated = new Product(1L, "Updated Laptop", 7, "Better Laptop", 1500.0);
        Mockito.when(productService.updateProduct(Mockito.eq(1L), Mockito.any())).thenReturn(updated);

        mockMvc.perform(put("/api/products/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Laptop"));
    }

    @Test
    void deleteProductTest() throws Exception {
        Mockito.doNothing().when(productService).deleteProduct(1L);

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Product deleted successfully!"));
    }
}
