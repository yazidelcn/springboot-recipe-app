package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.NotesCommand;
import com.elcnyazid.recipeapp.entities.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if(source == null) {
            return null;
        }

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setNotes(source.getNotes());
        return notesCommand;
    }
}
