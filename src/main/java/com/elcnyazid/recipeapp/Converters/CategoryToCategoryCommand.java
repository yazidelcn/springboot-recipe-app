package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.CategoryCommand;
import com.elcnyazid.recipeapp.entities.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Nullable
    @Synchronized
    @Override
    public CategoryCommand convert(Category category) {
        if(category != null){
            CategoryCommand categoryCommand = new CategoryCommand();
            categoryCommand.setId(category.getId());
            categoryCommand.setCategoryName(category.getCategoryName());
            return categoryCommand;
        }
        return null;
    }
}
