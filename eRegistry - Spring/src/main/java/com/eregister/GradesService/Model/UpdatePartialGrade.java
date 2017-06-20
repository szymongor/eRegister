package com.eregister.GradesService.Model;

/**
 * Created by Karo2 on 2017-06-18.
 */
public class UpdatePartialGrade {

    private String mark;
    private int weight;
    private String description;
    private String date;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
