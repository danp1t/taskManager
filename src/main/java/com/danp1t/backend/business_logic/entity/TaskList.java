package com.danp1t.backend.business_logic.entity;

import com.danp1t.backend.business_logic.exception.TaskNotAdded;
import com.danp1t.backend.business_logic.exception.TaskNotFound;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskList {

    private static TaskList _instance = null;

    public static TaskList getInstance(){
        if(_instance == null){
            _instance = new TaskList();
        }
        return _instance;
    }

    private int MAX_COUNT_TASKS = 50;

    public int getMAX_COUNT_TASKS() {
        return MAX_COUNT_TASKS;
    }

    public synchronized void setMAX_COUNT_TASKS(int MAX_COUNT_TASKS) {
        this.MAX_COUNT_TASKS = MAX_COUNT_TASKS;
    }

    private static final HashMap<Long,Task> taskList = new HashMap<>();

    public synchronized void AddTask(Task task) throws TaskNotAdded {
        if (taskList.size() < this.getMAX_COUNT_TASKS()) {
            taskList.put(task.taskId(),task);
        }
        else {
            throw new TaskNotAdded();
        }
    }

    public Task getTaskById(Long taskId) {
        return taskList.get(taskId);
    }

    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(taskList.values());
    }

    public synchronized void deleteTaskById(Long taskId) throws TaskNotFound {
        if(taskList.containsKey(taskId)){
            taskList.remove(taskId);
        }
        else{
            throw new TaskNotFound();
        }
    }
}
