package com.icet.controller;

import com.icet.dto.ProductDTO;
import com.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public void addProduct(@RequestBody ProductDTO productDTO){
        service.addProduct(productDTO);
    }

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/search")
    public List<ProductDTO> getProductsByNameCategoryOrBrand(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String category,
            @RequestParam(required = false, defaultValue = "") String brand) {

        return service.getProductByNameBrandOrCategory(name, brand, category);
    }
}
