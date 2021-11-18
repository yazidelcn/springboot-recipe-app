package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.UnitOfMeasureCommand;
import com.elcnyazid.recipeapp.entities.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {
    public static final String UOM = "Cup";
    public static final Long ID = 1L;
    UnitOfMeasureCommandToUnitOfMeasure converter;
    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }



    @DisplayName("Test null param")
    @Test
    void testNullParameter(){
        assertNull(converter.convert(null));
    }

    @DisplayName("Test empty object")
    @Test
    void testEmptyObject(){
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @DisplayName("Converter Method Test")
    @Test
    void convert() {
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(ID);
        command.setUom(UOM);
        UnitOfMeasure unitOfMeasure = converter.convert(command);
        assertEquals(ID, unitOfMeasure.getId());
        assertEquals(UOM, unitOfMeasure.getUom());
    }
}