package com.elcnyazid.recipeapp.service;

import com.elcnyazid.recipeapp.commands.RecipeCommand;
import com.elcnyazid.recipeapp.entities.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> findAll();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
