package org.example.model.entities.homeworknov16th;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    // ManyToOne relationship with Student class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}
