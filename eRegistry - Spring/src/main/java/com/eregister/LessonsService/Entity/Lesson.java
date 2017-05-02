package com.eregister.LessonsService.Entity;

/**
 * Created by Szymon on 15.04.2017.
 */


public class Lesson {

    private int id;
    private String year;
    private String semester;
    private int idTeacher;
    private int idGroup;
    private int idSubject;

    public Lesson() {
    }

    public Lesson(int id, String year, String semester, int idTeacher, int idGroup, int idSubject) {
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.idTeacher = idTeacher;
        this.idGroup = idGroup;
        this. idSubject = idSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup( int idGroup ) {
        this.idGroup = idGroup;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject( int idSubject) {
        this.idSubject = idSubject;
    }
}
