package com.elcnyazid.recipeapp.Converters;

import com.elcnyazid.recipeapp.commands.NotesCommand;
import com.elcnyazid.recipeapp.entities.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {
    public static final Long ID = 1L;
    public static final String NOTES = "Notes";
    NotesToNotesCommand converter;

    @BeforeEach
    void setUp(){
        converter = new NotesToNotesCommand();
    }

    @Test
    void convert() {
        Notes notes = new Notes();
        notes.setId(ID);
        notes.setNotes(NOTES);
        NotesCommand command =converter.convert(notes);
        assertEquals(ID,command.getId());
        assertEquals(NOTES,command.getNotes());
    }
}