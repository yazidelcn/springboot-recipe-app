package com.elcnyazid.recipeapp.entities;

import java.util.Set;

public class Recipe {
    private String Description;
    private int prepTime;
    private int cookTime;
    private int serving;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private byte[] image;
    private Notes notes;
    private Set<Ingredient> ingredientsSet;
    private Set<Category> categorySet;

}
