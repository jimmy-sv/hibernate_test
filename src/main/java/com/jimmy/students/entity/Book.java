package com.jimmy.students.entity;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="NAME",unique = true, nullable = false, length = 100)
    private String name;
    @Column(name="DESCRIPTION",unique = true, nullable = false, length = 100)
    private String description;
    @ManyToOne
    @JoinColumn(name="STUDENT_ID")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}