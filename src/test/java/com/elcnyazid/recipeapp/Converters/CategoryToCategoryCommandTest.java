package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.CategoryCommand;
import com.elcnyazid.recipeapp.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {
    public static final Long ID = 1L;
    public static final String NAME = "Category";
    CategoryToCategoryCommand converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryToCategoryCommand();
    }
    @DisplayName("Test Null parameter")
    @Test
    void testNullParam(){
        assertNull(converter.convert(null));
    }

    @DisplayName("Test Empty Object")
    @Test
    void testEmptyObj(){
        assertNotNull(converter.convert(new Category()));
    }

    @DisplayName("Test Convert Method")
    @Test
    void convert() {
        Category category = new Category();
        category.setId(ID);
        category.setCategoryName(NAME);
        CategoryCommand command = converter.convert(category);
        assertEquals(ID, command.getId());
        assertEquals(NAME, command.getCategoryName());
    }
}