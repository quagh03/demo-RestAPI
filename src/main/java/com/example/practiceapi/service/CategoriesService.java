package com.example.practiceapi.service;

import com.example.practiceapi.entity.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    List<Categories> getAllCategories();
    Categories addCategories(Categories categories);

    Optional<Categories> findCategoryById(Integer cid);

    void deleteCategoryById(Integer cid);

    void editCategory(Integer cid, Categories categories);
}
