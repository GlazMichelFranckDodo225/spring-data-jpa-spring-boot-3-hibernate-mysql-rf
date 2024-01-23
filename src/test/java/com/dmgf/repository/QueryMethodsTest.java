package com.dmgf.repository;

import com.dmgf.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    // JUnit Test for 'findByName()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByName()' Finder Method")
    void findByNameMethod() {
        Product product1 = productRepository.findByName("Product 2");

        System.out.println(product1);
        System.out.println(product1.getId());
        System.out.println(product1.getName());
        System.out.println(product1.getDescription());
        System.out.println(product1.getSku());
    }

    // JUnit Test for 'findById()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findById()' Finder Method")
    void findByIdMethod() {
        Long productId = 2L;

        Product product = productRepository.findById(productId).get();

        System.out.println(product);
    }
}
