package com.example.demo.group;

import jakarta.persistence.*;

@Entity
@Table(indexes = @Index(name = "group_id", columnList = "name"))
public class Group {
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
