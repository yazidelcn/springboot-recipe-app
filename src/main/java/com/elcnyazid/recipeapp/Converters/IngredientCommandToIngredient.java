package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.IngredientCommand;
import com.elcnyazid.recipeapp.entities.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

   UnitOfMeasureCommandToUnitOfMeasure converter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure converter) {
        this.converter = converter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null){
            return null;
        }
        else {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(source.getId());
            ingredient.setDescription(source.getDescription());
            ingredient.setAmount(source.getAmount());
            ingredient.setUom(converter.convert(source.getUom()));
            return ingredient;
        }
    }
}
