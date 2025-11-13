package com.lostfound.lostfound.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lostfound.lostfound.model.Category;
import com.lostfound.lostfound.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    public void deleteCategoryById(Long id){
      categoryRepository.deleteById(id);
    }
    public void deleteAllCategories(){
      categoryRepository.deleteAll();
    }

    public Category updateCategory(Long id, Category updatedCategory){
      return categoryRepository.findById(id)
        .map(category -> {
           category.setName(updatedCategory.getName());
    return categoryRepository.save(category);

        }).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
  }

}