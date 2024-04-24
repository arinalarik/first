package com.example.demo.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class GroupService {
    private GroupRepository repository;

    @Autowired
    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public List<Group> getAllGroup(){
        return repository.findAll();
    }

    public void createGroup(Group group){
        repository.save(group);
    }

    public void findOrCreateGroup(Group group){
        System.out.println(group);
        if (repository.findByName(group.getName())==null)
            repository.save(group);
    }

    public void checkGroup(Set<Group> tags){
        tags.forEach(this::findOrCreateGroup);
    }
}
