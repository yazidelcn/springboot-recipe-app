package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.NotesCommand;
import com.elcnyazid.recipeapp.entities.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesCommandToNotesTest {
    public static final Long ID = 1L;
    public static final String NOTES = "Notes";
    NotesCommandToNotes converter;

    @BeforeEach
    void setUp(){
        converter = new NotesCommandToNotes();
    }

    @Test
    void convert() {
        NotesCommand command = new NotesCommand();
        command.setId(ID);
        command.setNotes(NOTES);
        Notes notes =converter.convert(command);
        assertEquals(ID,notes.getId());
        assertEquals(NOTES,notes.getNotes());
    }
}