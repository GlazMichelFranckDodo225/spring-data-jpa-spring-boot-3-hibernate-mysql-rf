package com.dmgf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
