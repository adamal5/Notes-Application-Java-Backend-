package com.qa.notes.repo;

import com.qa.notes.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// each repository links to one specific table
@Repository
public interface NotesRepository extends JpaRepository <Note, Long> {
}
