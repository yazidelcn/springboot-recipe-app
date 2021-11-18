package com.elcnyazid.recipeapp.service;

import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImpTest {
    @InjectMocks
    RecipeServiceImp recipeServiceImp;
    @Mock
    RecipeRepository recipeRepository;

   /*@BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }*/
    @DisplayName("Find all method test")
    @Test
    void findAllTest(){
        //Given
        Set<Recipe> recipe = new HashSet<>();
        recipe.add(new Recipe());
        given(recipeRepository.findAll()).willReturn(recipe);
        //When
        Set<Recipe> recipes = recipeServiceImp.findAll();
        //Then
        then(recipeRepository).should().findAll();
        assertNotNull(recipes);
    }


}