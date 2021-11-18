package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.UnitOfMeasureCommand;
import com.elcnyazid.recipeapp.entities.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        if(unitOfMeasureCommand != null){
            UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
            unitOfMeasure.setId(unitOfMeasureCommand.getId());
            unitOfMeasure.setUom(unitOfMeasureCommand.getUom());
            return unitOfMeasure;
        }
        return null;
    }
}
