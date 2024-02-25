package com.dmgf.repository;

import com.dmgf.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Spring Data JPA Query Method - Find by Single Field Name
     * Query Method to Find or Retrieve a Product using its
     * Name as Search Criteria.
     * If no Product is Found, this Finder Method Returns "null".
     * @param name
     * @return
     */
    Product findByName(String name);
    /**
     * Query Method to Find or Retrieve a Product using its
     * Id as Search Criteria.
     * If no Product is Found, this Finder Method Returns an Empty Optional.
     * @param id
     * @return
     */
    Optional<Product> findById(Long id);
    /**
     * Query Methods to Find or Retrieve a Product using its
     * Fields as Search Criteria.
     * If no Product is Found, these Finder Methods Return an Empty List.
     * @param name
     * @param description
     * @return
     */
    List<Product> findByNameOrDescription(String name, String description);
    /**
     * Query Methods to Find or Retrieve a Product using its
     * Fields as Search Criteria.
     * If no Product is Found, these Finder Methods Return an Empty List.
     * @param name
     * @param description
     * @return
     */
    List<Product> findByNameAndDescription(String name, String description);
    /**
     * Query Method to Find or Retrieve a Distinct (or Unique) Product
     * using its Name as Search Criteria.
     * If no Product is Found, this Finder Method Returns "null".
     * @param name
     * @return
     */
    Product findDistinctByName(String name);
    /**
     * Query Method to Find or Retrieve a Product whose Price is Greater Than
     * given Price as Search Criteria.
     * If no Product is Found, this Finder Method Returns "null".
     * @param price
     * @return
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);
    /**
     * Query Method to Find or Retrieve a Product whose Price is Lesser Than
     * given Price as Search Criteria.
     * If no Product is Found, this Finder Method Returns "null".
     * @param price
     * @return
     */
    List<Product> findByPriceLessThan(BigDecimal price);
    /**
     * Query Method to Find or Retrieve Filtered Products that Match the
     * given Text as Search Criteria (Contains Check).
     * If no Product is Found, this Finder Method Returns an Empty List.
     * @param text
     * @return
     */
    List<Product> findByNameContaining(String text);
    /**
     * Query Method to Find or Retrieve Filtered Products Based on
     * a Price Range as Search Criteria (startPrice and endPrice).
     * If no Product is Found, this Finder Method Returns an Empty List.
     * @param startPrice
     * @param endPrice
     * @return
    */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
    /**
     * Query Method to Find or Retrieve Filtered Products Based on
     * a Date Range as Search Criteria (startDate and endDate).
     * If no Product is Found, this Finder Method Returns an Empty List.
     * @param startDate
     * @param endDate
     * @return
    */
    List<Product> findByDateCreatedBetween(
            LocalDateTime startDate, LocalDateTime endDate
    );
    /**
     * Query Method to Find or Retrieve Filtered Products Based on
     * Multiple String Values (names).
     * If no Product is Found, this Finder Method Returns an Empty List.
     * @param names
     * @return
     */
    List<Product> findByNameIn(List<String> names);
    // Spring Data JPA Query Method - Limiting Query Results
    List<Product> findFirst2ByOrderByNameAsc();
    List<Product> findTop2ByOrderByPriceDesc();
}
