package com.danp1t.backend.business_logic.entity;

import java.util.ArrayList;

public class TaskList {
    //TODO: Реализовать защиту, если превышен лимит задач
    public static final Integer MAX_COUNT_TASKS = 50;

    private static final ArrayList<Task> taskList = new ArrayList<Task>();

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void AddTask(Task task){
        taskList.add(task);
    }
}
