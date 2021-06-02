package com.example.ProjectDB.project;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class ProjectConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            ProjectRepository repository) {
        return args -> {
            Project shoot_em_up = new Project(
                    "Shoot em up",
                    "RPG Shooting c++",
                    5,
                    LocalDate.of(2021, JUNE, 1)
            );

            Project web_project = new Project(
                    "Web Project",
                    "Rent Books Online",
                    4,
                    LocalDate.of(2020, JUNE, 1)
            );

            repository.saveAll(
                    List.of(shoot_em_up, web_project)
            );
        };
    }
}
