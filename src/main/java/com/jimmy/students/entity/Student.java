package com.jimmy.students.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column
    private String name;
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    @Cascade({CascadeType.ALL})
    private List<Book> bookList = new ArrayList<Book>();

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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    /*@Override
    public boolean equals(Object obj) {
        if((obj == null) || (obj.getClass() != Student.class)) return false;
        if (this.getName().equalsIgnoreCase(((Student)obj).getName())) return true;
        else return false;
    }*/
}