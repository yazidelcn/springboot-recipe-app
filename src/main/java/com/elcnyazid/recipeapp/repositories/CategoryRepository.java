package com.elcnyazid.recipeapp.repositories;

import com.elcnyazid.recipeapp.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);
}
