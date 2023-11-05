package com.example.practiceapi.controller;

import com.example.practiceapi.dto.ProductsDto;
import com.example.practiceapi.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public List<ProductsDto> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/{pid}")
    public ResponseEntity<?> getProductById(@PathVariable Integer pid){
        try {
            return new ResponseEntity<>(productsService.getProductById(pid), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
