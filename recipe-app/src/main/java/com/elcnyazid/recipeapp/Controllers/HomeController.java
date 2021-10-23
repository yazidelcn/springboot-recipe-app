package com.elcnyazid.recipeapp.Controllers;

import com.elcnyazid.recipeapp.entities.Category;
import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.repositories.CategoryRepository;
import com.elcnyazid.recipeapp.repositories.RecipeRepository;
import com.elcnyazid.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {
    private final RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        Set<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes",recipes);
        System.out.println(recipes);
        return "index";
    }
}
