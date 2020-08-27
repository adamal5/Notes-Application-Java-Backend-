package com.qa.notes.service;

import com.qa.notes.domain.Note;
import com.qa.notes.exceptions.NoteNotFoundException;
import com.qa.notes.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NotesRepository repo;

    @Autowired
    public NoteService(NotesRepository repo) {
        this.repo = repo;
    }

  //Display all inputs on page

    public List<Note> readAllNotes(){
        return this.repo.findAll();
    }

  //create a note and save to repo

    public Note createNote(Note note){
        return this.repo.save(note);
    }

  // find a note by id type.. will be optional in order to run even if id does not exist .orElseThrow in case id does not exist
    public Note findNoteById(Long id){
        return this.repo.findById(id).orElseThrow(NoteNotFoundException::new);
    }

    public Note updateNote(Long id, Note note){
        Note update = findNoteById(id);
        update.setTitle(note.getTitle());
        update.setDescription(note.getDescription());
        return this.repo.save(update);
    }

    public boolean deleteNoteById(Long id){
        if(!this.repo.existsById(id)){
            throw new NoteNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
