package com.eregister.LessonsService.Entity;

/**
 * Created by Szymon on 15.04.2017.
 */


public class Lesson {

    private int id;
    private int year;
    private int semester;
    private String name;

    public Lesson() {
    }

    public Lesson(int id, int year, int semester, String name) {
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
