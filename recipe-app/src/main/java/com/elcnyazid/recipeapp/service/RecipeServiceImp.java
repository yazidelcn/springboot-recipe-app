package com.elcnyazid.recipeapp.service;

import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class RecipeServiceImp implements RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
