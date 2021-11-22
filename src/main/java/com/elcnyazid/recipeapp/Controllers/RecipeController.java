package com.elcnyazid.recipeapp.Controllers;

import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Controller
public class RecipeController {
    private  final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/recipe/{id}")
    public String showFullRecipe(@PathVariable Long id, Model model){
        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }

    /*@GetMapping("/")
    public String showRecipeForm(){
        return "recipe/";
    }*/
}
