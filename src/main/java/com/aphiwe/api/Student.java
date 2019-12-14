package com.aphiwe.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_Record")
public class Student {
    @Id
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="GPA")
    private int GPA;


    public Student(){

    }
    public Student(long id, String name, int GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", GPA=" + GPA +
                '}';
    }

    @JsonProperty
    public int getGPA() {
        return GPA;
    }
    @JsonProperty
    public void setId(long id) {
        this.id = id;
    }
    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty
    public void setGPA(int GPA) {
        this.GPA = GPA;
    }
}
