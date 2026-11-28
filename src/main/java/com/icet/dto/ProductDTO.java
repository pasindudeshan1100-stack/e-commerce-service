package com.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer productId;
    private  String name;
    private  String description;
    private  Double price;
    private  Integer quantity;
    private String category;
    private String  brand;
    private  String condition;
    private String imageUrl;
    private String sellerName;
    private  String location;
    private  Boolean isActive;
}
