package com.qa.notes.rest;

//controllers allow us to specify the urls against which the application will be responding
//each url will connect tp a service which links to the repository built on to the entity class
//better to have functionality split by pages

import com.qa.notes.domain.Note;
import com.qa.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// RestController will convert data to a standard JSON
@RestController
public class NotesController {

    private final NoteService noteService;

    @Autowired
    public NotesController(NoteService noteService){
        this.noteService = noteService;
    }

    //specifically used for read functionality/ browsers only able to work with getmapping
    @GetMapping("/")
    public List<Note> getAllNotes(){
        return this.noteService.readAllNotes();
    }


}
