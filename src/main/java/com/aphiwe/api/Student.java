package com.aphiwe.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private long id;
    private String name;
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
