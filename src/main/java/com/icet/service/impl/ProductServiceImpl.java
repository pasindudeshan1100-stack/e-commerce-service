package com.icet.service.impl;

import com.icet.dto.ProductDTO;
import com.icet.entity.ProductEntity;
import com.icet.repository.ProductRepository;
import com.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private  final ObjectMapper mapper;

    @Override
    public void addProduct(ProductDTO productDTO) {
        repository.save(mapper.convertValue(productDTO, ProductEntity.class));
    }
}
