package org.example.model.entities.homeworknov16th;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    // OneToMany relationship with Course class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "student")
    private List<Course> courseList;

}
