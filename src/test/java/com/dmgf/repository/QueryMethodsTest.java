package com.dmgf.repository;

import com.dmgf.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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

    // JUnit Test for 'findByNameOrDescriptionMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByNameOrDescriptionMethod()' Finder Method")
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription(
                "Product 2", "Product 2 Description"
        );

        products.forEach(product -> System.out.println(product));
    }

    // JUnit Test for 'findByNameAndDescriptionMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByNameAndDescriptionMethod()' Finder Method")
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription(
                "Product 4", "Product 4 Description"
        );

        products.forEach(product -> System.out.println(product));
    }

    // JUnit Test for 'findDistinctByNameMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findDistinctByNameMethod()' Finder Method")
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("Product 3");

        System.out.println(product);
    }

    // JUnit Test for 'findByPriceGreaterThanMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByPriceGreaterThanMethod()' Finder Method")
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository
                .findByPriceGreaterThan(new BigDecimal(100));

        products.forEach(product -> System.out.println(product));
    }

    // JUnit Test for 'findByPriceLessThanMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByPriceLessThanMethod()' Finder Method")
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository
                .findByPriceLessThan(new BigDecimal(400));

        products.forEach(product -> System.out.println(product));
    }
}
