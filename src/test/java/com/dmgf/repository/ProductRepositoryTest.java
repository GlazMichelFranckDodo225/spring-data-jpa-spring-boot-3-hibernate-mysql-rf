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
        // In this case, because "foundProduct" has any Primary Key yet, save()
        // Method will internally call EntityManager persist() Method to
        // Save "foundProduct"
        Product savedProduct = productRepository.save(product);

        // Display Product Info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct); // Use of toString() Method
    }

    // JUnit Test to Update a Product using ProductRepository Save Method
    @Test
    @DisplayName("JUnit Test to Update Product using ProductRepository Save Method")
    void updateUsingSaveMethod() {
        // Retrieve Product by Id from the DB
        Long productId = 1L;
        Product foundProduct = productRepository.findById(productId).get();

        // Update Retrieved Product
        foundProduct.setName("Product 1 - Updated");
        foundProduct.setDescription("Product 1 Description - Updated");

        // Save Updated a Product
        // In this case, because "foundProduct" has a Primary Key yet, save()
        // Method will internally call EntityManager merge() Method to
        // Update "foundProduct"
        Product updatedProduct = productRepository.save(foundProduct);

        // Display Upadated Product Info
        System.out.println(updatedProduct.getName());
        System.out.println(updatedProduct.getDescription());
    }

    // JUnit Test to Retrieve by Id a Single Product using
    // ProductRepository "findById()" Method
    @Test
    @DisplayName("JUnit Test to Retrieve by Id a Single Product")
    void findByIdMethod() {
        // Retrieve Product by Id from the DB
        // Typically this Id comes from Client
        Long productId = 1L;
        Product foundProduct = productRepository.findById(productId).get();

        // Display Upadated Product Info
        System.out.println(foundProduct.getName());
        System.out.println(foundProduct.getDescription());
    }
}
