package com.eticaret.demo.controller;

import com.eticaret.demo.Model.Category;
import com.eticaret.demo.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {



    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity < List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }


    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category){
        categoryService.creataCategory(category);

        return new ResponseEntity<>("Category added successfuly",HttpStatus.CREATED);

    }

    @DeleteMapping("/admin/categories/{categoryID}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryID){
        try {


            String status = categoryService.deletecategory(categoryID);
            return ResponseEntity.ok(status);
            // return new ResponseEntity<>(status,Httpstatus.OK);
            //Responseentity.status(Httpstatus.OK).body(status);
            // bunla hep aynı şeyler
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
    @PutMapping("/public/categories/{categoryID}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable Long categoryID){
        try {
            Category savedcategory = categoryService.updatecategory(category,categoryID);
             return new ResponseEntity<>("Category with category İD:"+categoryID,HttpStatus.OK);

        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
