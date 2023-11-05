package com.example.practiceapi.service;

import com.example.practiceapi.dto.ProductsDto;
import com.example.practiceapi.entity.Products;

import java.util.List;

public interface ProductsService {
    List<ProductsDto> getAllProducts();

    ProductsDto getProductById(Integer pid);

    void addProduct(ProductsDto productsDto);

    void deleteProduct(Integer pid);

    void editProduct(Integer pid, ProductsDto product);
}
