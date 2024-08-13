package com.example.unit5_demo.recyclerview;

import java.io.Serializable;

public class TaskDetail implements Serializable {
    private String name;
    private boolean isCompleted;
    private String notes;
    private int image;

    public TaskDetail(String name, boolean isCompleted, String notes, int image) {
        this.name = name;
        this.isCompleted = isCompleted;
        this.notes = notes;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
