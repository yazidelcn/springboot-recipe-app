package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.CategoryCommand;
import com.elcnyazid.recipeapp.entities.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>
{
    @Nullable
    @Synchronized
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        Category category = new Category();
        category.setId(source.getId());
        category.setCategoryName(source.getCategoryName());
        return category;
    }
}
