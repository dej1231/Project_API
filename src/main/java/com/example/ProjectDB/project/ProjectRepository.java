package com.example.ProjectDB.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository
        extends JpaRepository<Project, Long> {

  @Query("SELECT s FROM Project s WHERE s.name = ?1")
  Optional<Project> findProjectByName(String name);
}
