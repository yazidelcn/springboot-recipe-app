package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.IngredientCommand;
import com.elcnyazid.recipeapp.entities.Ingredient;
import com.elcnyazid.recipeapp.entities.Recipe;
import com.elcnyazid.recipeapp.entities.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
class IngredientToIngredientCommandTest {


    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = 2L;
    public static final Long ID= 1L;

    IngredientToIngredientCommand converter;



    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }
    @DisplayName("Testing convert with uom")
    @Test
    void convert() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        ingredient.setUom(uom);

        IngredientCommand command = converter.convert(ingredient);

        assertNotNull(command);
        assertAll(
                () -> assertEquals(ID, command.getId()),
                () -> assertEquals(AMOUNT, command.getAmount()),
                () -> assertEquals(DESCRIPTION, command.getDescription()),
                () -> assertEquals(UOM_ID, command.getUom().getId())
        );
    }
        @DisplayName("Testing convert with null uom")
        @Test
        void convertWithNullUom() {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(ID);
            ingredient.setRecipe(RECIPE);
            ingredient.setAmount(AMOUNT);
            ingredient.setDescription(DESCRIPTION);
            ingredient.setUom(null);

            IngredientCommand command = converter.convert(ingredient);

            assertNotNull(command);
            assertAll(
                    ()-> assertEquals(ID, command.getId()),
                    ()-> assertEquals(AMOUNT, command.getAmount()),
                    ()-> assertEquals(DESCRIPTION, command.getDescription()),
                    ()-> assertNull(command.getUom())
            );



    }
}