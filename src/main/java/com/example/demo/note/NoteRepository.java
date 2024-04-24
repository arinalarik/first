package com.example.demo.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByTitle(String title);

    @Query("SELECT n FROM Note n JOIN n.tags t WHERE t.name = :tagName")
    List<Note> findByTagName(@Param("tagName") String tagName);

    @Query("SELECT n FROM Note n LEFT JOIN n.tags t WHERE t IS NULL")
    List<Note> findUntagged();
}

