package com.elcnyazid.recipeapp.repositories;

import com.elcnyazid.recipeapp.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
