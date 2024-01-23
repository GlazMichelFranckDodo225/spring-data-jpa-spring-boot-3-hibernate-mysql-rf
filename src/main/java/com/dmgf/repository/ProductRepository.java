package com.dmgf.repository;

import com.dmgf.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /* Spring Data JPA Query Method - Find by Single Field Name */
    // Query Method to Find or Retrieve a Product using its
    // Name as Search Criteria.
    // If no Product is Found, this Finder Method Returns "null".
    Product findByName(String name);
    // Query Method to Find or Retrieve a Product using its
    // Id as Search Criteria.
    // If no Product is Found, this Finder Method Returns an Empty Optional.
    Optional<Product> findById(Long id);
}
