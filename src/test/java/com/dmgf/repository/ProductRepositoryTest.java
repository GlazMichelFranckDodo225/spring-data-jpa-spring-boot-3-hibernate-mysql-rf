package com.dmgf.repository;

import com.dmgf.entity.Product;
import com.dmgf.exception.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

// To Load a full Application Context of the Application containing
// all the Beans
@SpringBootTest
// To Test the Repository Layer (but in this case, we
// only Test the Repository Components)
// @DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    // JUnit Test for ProductRepository Save Method
    @Test
    @DisplayName("JUnit Test for ProductRepository Save Method")
    void saveMethod() {
        // Create Product
        Product product = Product.builder()
                .name("Product 1")
                .description("Product 1 Description")
                .sku("100ABC")
                .price(new BigDecimal(100))
                .active(true)
                .imageUrl("product1.png")
                .build();

        // Save Product
        Product savedProduct = productRepository.save(product);

        // Display Product Info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct); // Use of toString() Method
    }
}
