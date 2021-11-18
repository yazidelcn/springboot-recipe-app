package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.CategoryCommand;
import com.elcnyazid.recipeapp.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {
    public static final Long ID = 1L;
    public static final String NAME = "Category";
    CategoryCommandToCategory converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryCommandToCategory();
    }
    @DisplayName("Test Null parameter")
    @Test
    void testNullParam(){
        assertNull(converter.convert(null));
    }

    @DisplayName("Test Empty Object")
    @Test
    void testEmptyObj(){
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @DisplayName("Test Convert Method")
    @Test
    void convert() {
        CategoryCommand command = new CategoryCommand();
        command.setId(ID);
        command.setCategoryName(NAME);
        Category category = converter.convert(command);
        assertEquals(ID, command.getId());
        assertEquals(NAME, command.getCategoryName());
    }

}