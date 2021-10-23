package com.elcnyazid.recipeapp.Controllers;

import com.elcnyazid.recipeapp.entities.Category;
import com.elcnyazid.recipeapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String getHome(){
        Category cat = categoryRepository.findByCategoryName("American").get();
        String name = cat.getCategoryName();
        System.out.println(name);
        System.out.println(cat);
        return "index";
    }
}
