package com.eticaret.demo.Service;

import com.eticaret.demo.Model.Category;
import com.eticaret.demo.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceİmpl implements CategoryService {
    private List<Category>categories = new ArrayList<>();
    private long categoryIDnext=0;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
     //   return categories;  
        return categoryRepository.findAll();
    }

    @Override
    public void creataCategory(Category category) {
        category.setCategoryID(categoryIDnext++);
       // categories.add(category);   
        categoryRepository.save(category);

    }

    @Override
    public String deletecategory(Long categoryID) {
        Category category = categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));


        categoryRepository.delete(category);
        return "Category with categoryID: "+ categoryID + "deleted successfuly";
    }

    @Override
    public Category updatecategory(Category category, Long CategoryID) {


        Category savedCategory = categoryRepository.findById(CategoryID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));

        category.setCategoryID(CategoryID);
        savedCategory=categoryRepository.save(category);

        return savedCategory;
    }


}
