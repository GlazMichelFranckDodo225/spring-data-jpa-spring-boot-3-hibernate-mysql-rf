package com.dmgf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(
        name = "tbl_products",
        schema = "db_spring_data_jpa_hibernate_mysql_rf",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique", // DB Constraint Name
                        columnNames = "stock_keeping_unit" // DB Column Name
                ),
                @UniqueConstraint(
                        name = "name_unique", // DB Constraint Name
                        columnNames = "name" // DB Column Name

                )
        }
)
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator" // To Manually Specify Sequence - Optional
    )
    @SequenceGenerator( // To Manually Specify Sequence - Optional
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    // @CreationTimestamp and @UpdateTimestamp
    // To Hibernate Automatically gets the Timestamp Value from the
    // JVM and Assigns Values to the Filed
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
