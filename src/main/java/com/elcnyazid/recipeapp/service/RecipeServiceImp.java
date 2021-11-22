package com.elcnyazid.recipeapp.service;

import com.elcnyazid.recipeapp.Converters.RecipeCommandToRecipe;
import com.elcnyazid.recipeapp.Converters.RecipeToRecipeCommand;
import com.elcnyazid.recipeapp.commands.RecipeCommand;
import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Transactional
@Slf4j
public class RecipeServiceImp implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeServiceImp(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(!recipeOptional.isPresent() )
            throw new RuntimeException("Recipe not found");
        return recipeOptional.get();
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand){
        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
        Recipe savedRecipe =  recipeRepository.save(recipe);
        log.debug("Saved recipe ID  {}", savedRecipe.getId());
        return  recipeToRecipeCommand.convert(savedRecipe);
    }
}
