package com.example.ProjectDB.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects(){
       return  projectRepository.findAll();
    }

    public void addNewProject(Project project) {
        Optional<Project> projectOptional = projectRepository
                .findProjectByName(project.getName());
        if(projectOptional.isPresent()){
            throw new IllegalStateException("Name taken");
        }
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        boolean exists = projectRepository.existsById(projectId);
        if(!exists) {
            throw new IllegalStateException("project with id" + projectId + "does not exists");
        }
        projectRepository.deleteById(projectId);
    }

    @Transactional
    public void updateProject(Long projectId,
                              String name,
                              String description
                              ) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalStateException(
                        "Project with id" + projectId + "does not exists"));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(project.getName(), name)) {
            Optional<Project> projectOptional = projectRepository
                    .findProjectByName(name);
            if (projectOptional.isPresent()){
                throw new IllegalStateException("name taken");
            }
            project.setName(name);
        }

        if(description != null &&
                description.length() > 0 &&
                !Objects.equals(project.getDescription(), description)) {
            project.setName(description );
        }
    }
}
