package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.IngredientCommand;
import com.elcnyazid.recipeapp.entities.Ingredient;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source == null) {
            return null;
        }
        else {
            IngredientCommand command = new IngredientCommand();
            command.setId(source.getId());
            command.setDescription((source.getDescription()));
            command.setAmount(source.getAmount());
            command.setUom(unitOfMeasureToUnitOfMeasureCommand.convert(source.getUom()));
            return command;
        }
    }
}
