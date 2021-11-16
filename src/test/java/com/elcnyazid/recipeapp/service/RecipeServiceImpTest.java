package com.elcnyazid.recipeapp.service;

import com.elcnyazid.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImpTest {

    RecipeServiceImp recipeServiceImp;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
}