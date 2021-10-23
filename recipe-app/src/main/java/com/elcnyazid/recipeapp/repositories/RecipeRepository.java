package com.elcnyazid.recipeapp.repositories;

import com.elcnyazid.recipeapp.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
