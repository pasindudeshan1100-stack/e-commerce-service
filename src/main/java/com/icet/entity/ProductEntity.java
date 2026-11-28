package com.icet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private  String name;
    private  String description;
    private  Double price;
    private  Integer quantity;
    private String category;
    private String  brand;
    private  String productCondition;
    private String imageUrl;
    private String sellerName;
    private  String location;
    private  Boolean isActive;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        updatedAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }



}
