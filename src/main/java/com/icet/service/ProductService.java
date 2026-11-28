package com.icet.service;

import com.icet.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductByNameBrandOrCategory(String name,String category,String brand);
}
