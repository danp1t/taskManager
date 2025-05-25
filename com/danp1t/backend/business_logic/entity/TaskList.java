package com.danp1t.backend.business_logic.entity;

import java.util.ArrayList;

public class TaskList {
    public static final Integer MAX_COUNT_TASKS = 50;

    private static final ArrayList<Task> taskList = new ArrayList<Task>();

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void AddTask(Task task){
        if (taskList.size() < MAX_COUNT_TASKS) {
            taskList.add(task);
        }
        else {
            System.err.println("Не удалось добавить задачу в список, так как превышен лимит количества задач для одного пользователя");
        }
    }
}
