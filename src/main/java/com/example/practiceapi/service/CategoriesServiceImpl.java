package com.example.practiceapi.service;

import com.example.practiceapi.entity.Categories;
import com.example.practiceapi.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService{
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();
    }

    @Override
    public Categories addCategories(Categories categories) {
        return categoriesRepository.save(categories);
    }

    @Override
    public Optional<Categories> findCategoryById(Integer cid){
        return categoriesRepository.findById(cid);
    }

    @Override
    public void deleteCategoryById(Integer cid){
        try{
            Optional<Categories> tempCategory = this.findCategoryById(cid);

            if(tempCategory.isPresent()){
                categoriesRepository.deleteById(cid);
            }else{
                throw new IllegalArgumentException("Category with ID " + cid + " not found");
            }
        }catch (Exception e){
            throw new RuntimeException("Error deleting category: " + e.getMessage());
        }
    }

    @Override
    public void editCategory(Integer cid, Categories categories) {
        try {
            Optional<Categories> tempCategory = this.findCategoryById(cid);

            if (tempCategory.isPresent()){
                Categories existingCategory = tempCategory.get();
                existingCategory.setCname(categories.getCname());
                existingCategory.setCdesc(categories.getCdesc());
                existingCategory.setCstatus(categories.getCstatus());

                categoriesRepository.save(existingCategory);
            }else{
                throw new IllegalArgumentException("Category with ID " + cid + " not found");
            }
        }catch (Exception e){
            throw new RuntimeException("Error editing category: " + e.getMessage());
        }
    }
}
