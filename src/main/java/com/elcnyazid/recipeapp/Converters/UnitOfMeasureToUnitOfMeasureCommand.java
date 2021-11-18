package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.UnitOfMeasureCommand;
import com.elcnyazid.recipeapp.entities.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        if( unitOfMeasure == null){
            return null;
        }
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(unitOfMeasure.getId());
        unitOfMeasureCommand.setUom(unitOfMeasure.getUom());
        return  unitOfMeasureCommand;
    }
}
