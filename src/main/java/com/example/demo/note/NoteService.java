package com.example.demo.note;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoteService {
    private NoteRepository repository;
    @Autowired
    public NoteService(NoteRepository notesRepository){
        this.repository = notesRepository;
    }

    public List<Note> getAllNote() {
        return repository.findAll();
    }

    public List<Note> getNoteByTitle(String title){
        return repository.findByTitle(title);
    }


    public Optional<Note> getNoteById(int id){
        Optional<Note> note = repository.findById(id);
        return note;
    }

    public ResponseEntity<?> saveNote(Note note) {
        repository.save(note);
        return ResponseEntity.status(201).body(note);
    }

    public void deleteNote(int noteId){
        Note note = repository
                .findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note not found with id " + noteId));
        repository.delete(note);
    }

    public void deleteAllNote(){
        repository.deleteAll();
    }

    public List<Note> getTaggedNote(String tagName){
        return repository.findByTagName(tagName);
    }

    public List<Note> getUntaggedNote(){
        return repository.findUntagged();
    }
}
