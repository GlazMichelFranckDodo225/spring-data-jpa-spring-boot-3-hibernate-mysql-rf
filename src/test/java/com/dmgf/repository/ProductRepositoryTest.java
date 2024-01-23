package com.dmgf.repository;

import com.dmgf.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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

        // Display Found Product Info
        System.out.println(foundProduct.getName());
        System.out.println(foundProduct.getDescription());
    }

    // JUnit Test to Save Multiple Entities to the DB
    @Test
    @DisplayName("JUnit Test to Save Multiple Entities to the DB")
    void saveAllMethod() {
        // Create 3 Products
        Product product2 = Product.builder()
                .name("Product 2")
                .description("Product 2 Description")
                .sku("200ABC")
                .price(new BigDecimal(200))
                .active(true)
                .imageUrl("product2.png")
                .build();

        Product product3 = Product.builder()
                .name("Product 3")
                .description("Product 3 Description")
                .sku("300ABC")
                .price(new BigDecimal(300))
                .active(true)
                .imageUrl("product3.png")
                .build();

        Product product4 = Product.builder()
                .name("Product 4")
                .description("Product 4 Description")
                .sku("400ABC")
                .price(new BigDecimal(400))
                .active(true)
                .imageUrl("product4.png")
                .build();

        // Save All the 3 Products
        List<Product> savedProducts = productRepository.saveAll(
                List.of(product2, product3, product4)
        );

        // Display All Saved Products Info
        for(Product product: savedProducts) {
            System.out.println("Id : " + product.getId() + " - " + product.getName());
        }
    }

    // JUnit Test to Retrieve All the Entities to the DB
    @Test
    @DisplayName("JUnit Test to Retrieve All the Entities to the DB")
    void findAllMethod() {
        // Retrieve All the Entities to the DB
        List<Product> products = productRepository.findAll();

        // Display All Retrieved Products Info
        products.forEach(product ->
                System.out.println("Id : " + product.getId() + " - " + product.getName())
        );
    }

    // JUnit Test for deleteById() Method - Delete a Single Entity from the Database
    @Test
    @DisplayName("JUnit Test for deleteById() Method - Delete a Single Entity from the Database")
    void deleteByIdMethod() {
        // Retrieve Product by Id from the DB
        // Typically this Id comes from Client
        Long productId = 4L;

        List<Product> productsBeforeDeleting = productRepository.findAll();
        productsBeforeDeleting.forEach(product ->
                System.out.println(product.getId()));

        productRepository.deleteById(productId);

        List<Product> productsAfterDeleting = productRepository.findAll();
        productsAfterDeleting.forEach(product ->
                System.out.println(product.getId()));
    }

    // JUnit Test for delete() Method - Delete a Single Entity from the Database
    @Test
    @DisplayName("JUnit Test for delete() Method - Delete an Entity from the Database")
    void deleteMethod() {
        // Retrieve Product by Id from the DB
        // Typically this Id comes from Client
        Long productId = 3L;
        Product foundProduct = productRepository.findById(productId).get();

        List<Product> productsBeforeDeleting = productRepository.findAll();
        productsBeforeDeleting.forEach(product ->
                System.out.println(product.getId()));

        productRepository.delete(foundProduct);

        List<Product> productsAfterDeleting = productRepository.findAll();
        productsAfterDeleting.forEach(product ->
                System.out.println(product.getId()));
    }

    // JUnit Test for deleteAll() Method - FIRST WAY - Delete All the Entities From
    // the Database Table
    @Test
    @DisplayName("JUnit Test for deleteAll() Method")
    void deleteAllMethodFirstWay() {
        List<Product> productsBeforeDeleting = productRepository.findAll();
        productsBeforeDeleting.forEach(product ->
                System.out.println(product.getId()));

        productRepository.deleteAll();

        List<Product> productsAfterDeleting = productRepository.findAll();
        productsAfterDeleting.forEach(product ->
                System.out.println(product.getId()));
    }

    // JUnit Test for deleteAll() Method - SECOND WAY - Delete All the Entities
    // From the Database Table
    @Test
    @DisplayName("JUnit Test for deleteAll() Method")
    void deleteAllMethod() {
        List<Product> productsBeforeDeleting = productRepository.findAll();
        productsBeforeDeleting.forEach(product ->
                System.out.println(product.getId()));

        Product product1 = productRepository.findById(5L).get();
        Product product2 = productRepository.findById(6L).get();
        Product product3 = productRepository.findById(7L).get();

        productRepository.deleteAll(List.of(product1, product2, product3));

        List<Product> productsAfterDeleting = productRepository.findAll();
        productsAfterDeleting.forEach(product ->
                System.out.println(product.getId()));
    }

    // JUnit Test for count() Method - Count all the Records into the Table
    @Test
    @DisplayName("JUnit Test for count() Method")
    void countMethod() {
        long numberOfDbRecords = productRepository.count();

        System.out.println("There are " + numberOfDbRecords + " Records into the Table");
    }

    // JUnit Test for existsById() Method - Check if Entity Exists With Given ID in
    // the Database Table
    @Test
    @DisplayName("JUnit Test for existsById() Method")
    void existsByIdMethod() {
        // Long productId = 8L;
        Long productId = 15L;
        boolean result = productRepository.existsById(productId);

        if(result) {
        System.out.println("The Product with Id " + productId + " is " +
                        "Present into the Product Table");
        }
        else {
        System.out.println("The Product with Id " + productId + " Does Not Exists " +
                "into the Product Table");
        }
    }
}
