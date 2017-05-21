package com.eregister.GroupsService.Entity;

/**
 * Created by Karo2 on 2017-05-17.
 */
public class Group {
    private int id;
    private String name;
    private String year;
    private boolean active;

    public Group() {
    }

    public Group(int id, String name, String year, boolean active) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.active = active;
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
