package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.UnitOfMeasureCommand;
import com.elcnyazid.recipeapp.entities.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

class UnitOfMeasureToUnitOfMeasureCommandTest {
    public static final String uom = "Cup";
    public static final Long id = 1L;

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @BeforeEach
    void setUp() {
        unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @DisplayName("Test null param")
    @Test
    void testNullParameter(){
        assertNull(unitOfMeasureToUnitOfMeasureCommand.convert(null));
    }

    @DisplayName("Test empty object")
    @Test
    void testEmptyObject(){
        assertNotNull(unitOfMeasureToUnitOfMeasureCommand.convert(new UnitOfMeasure()));
    }


    @DisplayName("Test convert method")
    @Test
    void testConvert(){
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(id);
        unitOfMeasure.setUom(uom);
        UnitOfMeasureCommand command = unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasure);
        assertEquals(1L, command.getId());
        assertEquals("Cup", command.getUom());
    }
}