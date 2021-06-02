package com.example.ProjectDB.project;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Project {

    @Id
    @SequenceGenerator(
            name ="project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )


    private Long id;
    private String name;
    private String description;
    private Integer rating;
    private LocalDate date;

    public Project() {
    }

    public Project(Long id, String name, String description, Integer rating, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.date = date;
    }

    public Project(String name, String description, Integer rating, LocalDate date) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}
