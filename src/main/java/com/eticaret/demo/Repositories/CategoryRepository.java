package com.eticaret.demo.Repositories;

import com.eticaret.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
