package com.eticaret.demo.Service;

import com.eticaret.demo.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void creataCategory(Category category);

    String deletecategory(Long categoryID);

    Category updatecategory(Category category,Long CategoryID);


}
