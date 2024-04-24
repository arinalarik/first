package com.example.demo.note;

import com.example.demo.group.Group;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(
            fetch = FetchType.EAGER
    )

    @JoinColumn(
            name = "notes",
            referencedColumnName = "id"
    )

    @NotNull
    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToMany
    @JoinTable(name = "notes_group",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "group_name"))
    private Set<Group> group;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Group> getGroup() {
        return group;
    }

    public void setTags(Set<Group> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", group=" + group +
                '}';
    }
}
