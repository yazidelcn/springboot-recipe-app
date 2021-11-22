package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.RecipeCommand;
import com.elcnyazid.recipeapp.entities.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final NotesCommandToNotes notesCommandToNotes;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final CategoryCommandToCategory categoryCommandToCategory;

    public RecipeCommandToRecipe(NotesCommandToNotes notesCommandToNotes, IngredientCommandToIngredient ingredientCommandToIngredient, CategoryCommandToCategory categoryCommandToCategory) {
        this.notesCommandToNotes = notesCommandToNotes;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source == null) {
            return null;
        }
        else {
            Recipe recipe= new Recipe();
            recipe.setId(source.getId());
            recipe.setCookTime(source.getCookTime());
            recipe.setPrepTime(source.getPrepTime());
            recipe.setDescription(source.getDescription());
            recipe.setDifficulty(source.getDifficulty());
            recipe.setDirections(source.getDirections());
            recipe.setServing(source.getServings());
            recipe.setSource(source.getSource());
            recipe.setUrl(source.getUrl());
            recipe.setNotes(notesCommandToNotes.convert(source.getNotes()));
            if(source.getCategories() != null && source.getCategories().size() > 0){
                source.getCategories().forEach(
                        categoryCommand -> {
                            recipe.getCategories().add(categoryCommandToCategory.convert(categoryCommand));
                        }
                );
            }
            if(source.getIngredients() != null && source.getIngredients().size() > 0){
                source.getIngredients().forEach(ingredientCommand -> {
                    recipe.getIngredients().add(ingredientCommandToIngredient.convert(ingredientCommand));
                });
            }
            return recipe;
        }
    }
}
