package com.surya.rk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.rk.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // No extra code needed for basic CRUD
}