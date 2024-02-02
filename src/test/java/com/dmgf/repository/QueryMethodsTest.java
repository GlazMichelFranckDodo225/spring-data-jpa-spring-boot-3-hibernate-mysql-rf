package com.dmgf.repository;

import com.dmgf.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    // JUnit Test for 'findByNameContainingMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByNameContainingMethod()' Finder Method")
    void findByNameContainingMethod() {
        List<Product> products = productRepository
                .findByNameContaining("product");

        products.forEach(product -> System.out.println(product));
    }

    /*// JUnit Test for 'findByNameLikeMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByNameLikeMethod()' Finder Method")
    void findByNameLikeMethod() {
        List<Product> products = productRepository
                .findByNameLike("product");
        System.out.println("Trace");
        System.out.println(products);
        products.forEach(product -> System.out.println(product));
    }*/

    // JUnit Test for 'findByPriceBetweenMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByPriceBetweenMethod()' Finder Method")
    void findByPriceBetweenMethod() {
        BigDecimal startPrice = new BigDecimal(100);
        BigDecimal endPrice = new BigDecimal(500);

        List<Product> products = productRepository
                .findByPriceBetween(startPrice, endPrice);

        // products.forEach(product -> System.out.println(product));
        products.forEach(System.out::println);
    }

    // JUnit Test for 'findByDateCreatedBetweenMethod()' Finder Method
    @Test
    @DisplayName("JUnit Test for 'findByDateCreatedBetweenMethod()' Finder Method")
    void findByDateCreatedBetweenMethod() {
        // Typically, We Can Pick Dates from DB
        LocalDateTime starDate =
                LocalDateTime.of(
                2024, 01, 22,  00, 00, 00, 000000
        );
        LocalDateTime endDate =
                LocalDateTime.of(
                2024, 01, 24,  00, 00, 00, 000000
        );

        List<Product> products = productRepository
                .findByDateCreatedBetween(starDate, endDate);

        // products.forEach(product -> System.out.println(product));
        products.forEach(System.out::println);
    }
}
