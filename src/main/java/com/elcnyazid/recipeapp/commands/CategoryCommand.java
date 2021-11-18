package com.elcnyazid.recipeapp.commands;

import com.elcnyazid.recipeapp.entities.Recipe;

import java.util.HashSet;
import java.util.Set;

public class CategoryCommand {
    private Long id;
    private String categoryName;
    private Set<Recipe> recipes = new HashSet<>();
}
