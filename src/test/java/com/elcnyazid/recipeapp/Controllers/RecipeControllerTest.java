package com.elcnyazid.recipeapp.Controllers;

import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @InjectMocks
    RecipeController recipeController;
    @Mock
    RecipeService recipeService;
    MockMvc mockMvc;
    Recipe recipe;

    @BeforeEach
    void setUp(){
     mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
     recipe = new Recipe();
     recipe.setId(1L);
    }

    @Test
    @DisplayName("Show Full Recipe By ID")
    void showFullRecipeTest() throws Exception {
        given(recipeService.findById(anyLong())).willReturn(recipe);

        mockMvc.perform(get("/recipe/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
        verify(recipeService, atLeastOnce()).findById(anyLong());
    }
}