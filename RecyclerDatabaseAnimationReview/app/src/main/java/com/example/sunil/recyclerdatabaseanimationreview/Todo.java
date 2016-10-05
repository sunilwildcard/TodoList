package com.example.sunil.recyclerdatabaseanimationreview;

/**
 * Created by sunil on 9/16/16.
 */

public class Todo {

    private String title;
    private String description;

    public Todo(){}

    public Todo(String t, String d){
        title = t;
        description = d;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
