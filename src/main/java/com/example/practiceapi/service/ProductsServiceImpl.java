package com.example.practiceapi.service;

import com.example.practiceapi.dto.CategoriesDto;
import com.example.practiceapi.dto.ProductsDto;
import com.example.practiceapi.entity.Categories;
import com.example.practiceapi.entity.Products;
import com.example.practiceapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductsDto> getAllProducts(){
        List<ProductsDto> productsDtoList = productRepository.findAll().stream()
                .map(product -> {
                    ProductsDto productsDto = new ProductsDto();
                    productsDto.setPid(product.getPid());
                    productsDto.setPdesc(product.getPdesc());
                    productsDto.setPname(product.getPname());
                    productsDto.setPstatus(product.getPstatus());

                    CategoriesDto categoriesDto = new CategoriesDto();
                    Categories productCategory = product.getCategories();
                    categoriesDto.setCid(productCategory.getCid());
                    categoriesDto.setCname(productCategory.getCname());
                    categoriesDto.setCdesc(productCategory.getCdesc());
                    categoriesDto.setCstatus(productCategory.getCstatus());

                    productsDto.setCategories(categoriesDto);

                    return productsDto;
                })
                .collect(Collectors.toList());

        return productsDtoList;
    }

    @Override
    public ProductsDto getProductById(Integer pid){
        try {
            Optional<Products> tempProduct = productRepository.findById(pid);

            if(tempProduct.isPresent()){
                Products product = tempProduct.get();
                Categories tempCategory = product.getCategories();

                CategoriesDto categoriesDto = new CategoriesDto(
                        tempCategory.getCid(),
                        tempCategory.getCname(),
                        tempCategory.getCdesc(),
                        tempCategory.getCstatus()
                );

                return new ProductsDto(
                        product.getPid(),
                        product.getPname(),
                        product.getPdesc(),
                        product.getPstatus(),
                        categoriesDto
                );
            }else{
                throw new IllegalArgumentException("Product with ID " + pid + " not found");
            }
        }catch (Exception e){
            throw new RuntimeException("Error finding product: " + e.getMessage());
        }
    }
}
