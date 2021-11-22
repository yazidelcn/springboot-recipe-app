package com.elcnyazid.recipeapp.service;

import com.elcnyazid.recipeapp.Converters.RecipeCommandToRecipe;
import com.elcnyazid.recipeapp.Converters.RecipeToRecipeCommand;
import com.elcnyazid.recipeapp.commands.RecipeCommand;
import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeServiceIT {
    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    public String newDescription = "New Description";

    @Test
    @Transactional
    @DisplayName("saveRecipe Integration test")
    void testSaveRecipe(){
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe recipe = recipes.iterator().next();
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);

        //when
        recipeCommand.setDescription(newDescription);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);
        //then
        assertEquals(newDescription, savedRecipeCommand.getDescription());
        assertEquals(recipeCommand.getId(), savedRecipeCommand.getId());



    }
}
