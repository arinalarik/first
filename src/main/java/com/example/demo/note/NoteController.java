package com.example.demo.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/notes")
@RestController
public class NoteController {
    private NoteService service;
    private NoteMerger noteMerger;

    @Autowired
    public NoteController(NoteService notesService, NoteMerger noteMerger) {
        this.service = notesService;
        this.noteMerger = noteMerger;
    }

    @GetMapping
    public List<Note> getAllNote() {
        return service.getAllNote();
    }

    @GetMapping(path = "{noteId}")
    public Optional<Note> getNote(@PathVariable int noteId) {
        return service.getNoteById(noteId);
    }

    @GetMapping(params = {"find_by", "value"})
    public List<Note> getNotesBy(@RequestParam String find_by, @RequestParam String value) {
        if (find_by.equals("title")) {
            return service.getNoteByTitle(value);
        }


        return null;
    }
}
