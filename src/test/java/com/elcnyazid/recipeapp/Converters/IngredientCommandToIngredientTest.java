package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.IngredientCommand;
import com.elcnyazid.recipeapp.commands.UnitOfMeasureCommand;
import com.elcnyazid.recipeapp.entities.Ingredient;
import com.elcnyazid.recipeapp.entities.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = 2L;
    public static final Long ID= 1L;
    IngredientCommandToIngredient converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    void convert() {
        IngredientCommand command = new IngredientCommand();
        command.setId(ID);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        command.setUom(unitOfMeasureCommand);

        Ingredient ingredient = converter.convert(command);

        assertNotNull(ingredient);
        assertAll(
                () -> assertEquals(ID, ingredient.getId()),
                () -> assertEquals(AMOUNT, ingredient.getAmount()),
                () -> assertEquals(DESCRIPTION, ingredient.getDescription()),
                () -> assertEquals(UOM_ID, ingredient.getUom().getId())
        );
    }
}