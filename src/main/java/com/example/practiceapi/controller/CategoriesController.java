package com.example.practiceapi.controller;

import com.example.practiceapi.entity.Categories;
import com.example.practiceapi.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public List<Categories> getAllCategories(){
        return categoriesService.getAllCategories();
    }

    @GetMapping("/{cid}")
    public Optional<Categories> getCategoryById(@PathVariable Integer cid){
        return categoriesService.findCategoryById(cid);
    }

    @PostMapping
    public Categories addCategories(@RequestBody Categories categories){
        return categoriesService.addCategories(categories);
    }

    @DeleteMapping("/{cid}")
    public ResponseEntity<?> deteleCategoryById(@PathVariable Integer cid){
        try{
            categoriesService.deleteCategoryById(cid);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Deleted category with ID " + cid, HttpStatus.OK);
    }

    @PutMapping("/{cid}")
    public ResponseEntity<?> editCategory(@PathVariable Integer cid, @RequestBody Categories category){
        try {
            categoriesService.editCategory(cid, category);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Edited category with ID " + cid, HttpStatus.OK);
    }
}
