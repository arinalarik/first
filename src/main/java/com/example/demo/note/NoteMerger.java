package com.example.demo.note;


import com.example.demo.group.Group;
import com.example.demo.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class NoteMerger {

    private GroupService groupService;

    private NoteMerger(GroupService groupService) {
    }

    @Autowired
    public void setTagService(GroupService tagService) {
        this.groupService = tagService;
    }

    public void merge(Note note, Note tempNote){
        String title = tempNote.getTitle();
        String text = tempNote.getText();
        Set<Group> tags = tempNote.getGroup();

        if (title!=null)
            note.setTitle(title);
        if (text!=null)
            note.setText(text);
        if (tags!=null){
            groupService.checkGroup(tags);
            note.setTags(tags);
        }

    }
}