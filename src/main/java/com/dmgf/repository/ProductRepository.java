package com.dmgf.repository;

import com.dmgf.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
    // Query Methods to Find or Retrieve a Product using its
    // Fields as Search Criteria.
    // If no Product is Found, these Finder Methods Return an Empty List.
    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);
    // Query Method to Find or Retrieve a Distinct (or Unique) Product
    // using its Name as Search Criteria.
    // If no Product is Found, this Finder Method Returns "null".
    Product findDistinctByName(String name);
    // Query Method to Find or Retrieve a Product whose Price is Greater Than
    // given Price as Search Criteria.
    // If no Product is Found, this Finder Method Returns "null".
    List<Product> findByPriceGreaterThan(BigDecimal price);
    // Query Method to Find or Retrieve a Product whose Price is Lesser Than
    // given Price as Search Criteria.
    // If no Product is Found, this Finder Method Returns "null".
    List<Product> findByPriceLessThan(BigDecimal price);
    // Query Method to Find or Retrieve Filtered Products that Match the
    // given Text as Search Criteria (Contains Check).
    // If no Product is Found, this Finder Method Returns an Empty List.
    List<Product> findByNameContaining(String text);
    /*// Query Method to Find or Retrieve Filtered Products Based on
    // a Price Range as Search Criteria (startPrice and endPrice).
    // If no Product is Found, this Finder Method Returns an Empty List.*/
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
    /*// Query Method to Find or Retrieve Filtered Products Based on
    // a Date Range as Search Criteria (startDate and endDate).
    // If no Product is Found, this Finder Method Returns an Empty List.*/
    List<Product> findByDateCreatedBetween(
            LocalDateTime startDate, LocalDateTime endDate
    );

}
