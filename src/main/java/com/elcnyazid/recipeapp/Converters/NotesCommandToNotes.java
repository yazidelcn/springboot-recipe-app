package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.NotesCommand;
import com.elcnyazid.recipeapp.entities.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if(source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setNotes(source.getNotes());
        return notes;
    }
}
