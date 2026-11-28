package com.icet.service.impl;

import com.icet.dto.ProductDTO;
import com.icet.entity.ProductEntity;
import com.icet.repository.ProductRepository;
import com.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private  final ObjectMapper mapper;

    @Override
    public void addProduct(ProductDTO productDTO) {
        repository.save(mapper.convertValue(productDTO, ProductEntity.class));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        Iterable<ProductEntity> all = repository.findAll();
        ArrayList<ProductDTO> productDTOArrayList = new ArrayList<>();
        all.forEach(productEntity -> productDTOArrayList.add(new ModelMapper().map(productEntity,ProductDTO.class)));
        return productDTOArrayList;
    }

    @Override
    public List<ProductDTO> getProductByNameBrandOrCategory(String name,String category,String brand) {

        Iterable<ProductEntity> products;
        if (name.isEmpty() && category.isEmpty() && brand.isEmpty()) {
            products = repository.findAll();
        } else {
            products = repository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCaseOrCategoryContainingIgnoreCase(
                    name, brand, category
            );
        }

       ArrayList<ProductDTO> productDTOArrayList=new ArrayList<>();
       products.forEach(productEntity -> productDTOArrayList.add(new ModelMapper().map(productEntity, ProductDTO.class)));
       return productDTOArrayList;
    }


}
