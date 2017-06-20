package com.eregister.GradesService.Model;

/**
 * Created by Karo2 on 2017-06-18.
 */
public class UpdateFinalGrade {

    private int id;
    private String mark;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
