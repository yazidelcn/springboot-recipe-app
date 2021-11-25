package com.elcnyazid.recipeapp.Controllers;

import com.elcnyazid.recipeapp.commands.RecipeCommand;
import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/recipe/new")
    public String showRecipeForm(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipe-form";
    }

    @PostMapping("/recipe/")
    public String addRecipe(@ModelAttribute RecipeCommand recipeCommand){
        RecipeCommand saved = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/"+saved.getId();
    }
}
