package com.example.sunil.recyclerdatabaseanimationreview;

import java.util.ArrayList;

/**
 * Created by sunil on 10/4/16.
 */

public class TodoSingleton {

    private static TodoSingleton sInstance;
    private ArrayList<Todo>TodoList;

    public static TodoSingleton getInstance(){
        if(sInstance==null)
         sInstance = new TodoSingleton();
        return sInstance;
    }

    private TodoSingleton(){
        TodoList = new ArrayList<>();
    }

    public void addToList(Todo t){
        TodoList.add(t);
    }

    public ArrayList<Todo> getTodoList(){return TodoList;}
}
