package com.example.practiceapi.controller;

import com.example.practiceapi.dto.ProductsDto;
import com.example.practiceapi.entity.Products;
import com.example.practiceapi.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductsDto productsDto){
        try{
            productsService.addProduct(productsDto);
        }catch (Exception e){
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added product", HttpStatus.CREATED);
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer pid){
        try {
            productsService.deleteProduct(pid);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Deleted product with ID: " + pid, HttpStatus.OK);
    }

    @PutMapping("/{pid}")
    public ResponseEntity<?> editProduct(@PathVariable Integer pid, @RequestBody ProductsDto product){
        try{
            productsService.editProduct(pid, product);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Updated product with Id: " + pid, HttpStatus.OK);
    }
}
