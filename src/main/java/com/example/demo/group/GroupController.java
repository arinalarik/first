package com.example.demo.group;

import com.example.demo.note.NoteService;
import com.example.demo.note.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/tags")
@RestController
public class GroupController {
    private GroupService service;
    private NoteService noteService;

    @Autowired
    public GroupController(GroupService service, NoteService noteService) {
        this.service = service;
        this.noteService = noteService;
    }

    @GetMapping
    public List<Group> getAllTags(){
        return service.getAllGroup();
    }

    @GetMapping(path = "_untagged_")
    private List<Note> getUntaggedNotes(){
        return noteService.getUntaggedNote();
    }

    @GetMapping(path = "{tagName}")
    private List<Note> getTaggedNotes(@PathVariable String tagName){
        return noteService.getTaggedNote(tagName);
    }
}
