package com.danp1t.backend.business_logic.entity;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author danp1t
 * @since 0.0.1
 * Данный клас описывает сущность "Задача"
 */
public class Task {
    /**
     * @since 0.0.1
     * id - уникальный индетификатор задачи
     * name - название задачи
     * deadline - дедлайн задачи
     * cost - цена/вес задачи
     * priority - приоритет задачи
     */
    private static final AtomicLong idCounter = new AtomicLong(0);

    private final Long taskId;
    private String name;
    private LocalDateTime deadline;
    private Integer cost;
    private Priority priority;

    /**
     * Различные конструкторы для создания объекта "Задача"
     */
    public Task(){
        this.taskId = idCounter.getAndIncrement();
        this.name = "Без названия";
        this.cost = 0;
        this.deadline = null;
        this.priority = Priority.NOT_STATED;
    }

    public Task(String name){
        this.taskId = idCounter.getAndIncrement();
        this.name = name;
        this.cost = 0;
        this.deadline = null;
        this.priority = Priority.NOT_STATED;
    }

    public Task(String name, Integer cost){
        this.taskId = idCounter.getAndIncrement();
        this.name = name;
        this.cost = cost;
        this.deadline = null;
        this.priority = Priority.NOT_STATED;
    }

    public Task(String name, Integer cost, LocalDateTime deadline){
        this.taskId = idCounter.getAndIncrement();
        this.name = name;
        this.cost = cost;
        this.deadline = deadline;
        this.priority = Priority.NOT_STATED;
    }

    public Task(String name, Integer cost, LocalDateTime deadline, Priority priority){
        this.taskId = idCounter.getAndIncrement();
        this.name = name;
        this.cost = cost;
        this.deadline = deadline;
        this.priority = priority;
    }

    // Getters для данного класс
    public Long getTaskId(){
        return this.taskId;
    }

    public String getName(){
        return this.name;
    }

    public LocalDateTime getDeadline(){
        return this.deadline;
    }

    public Integer getCost(){
        return this.cost;
    }

    public Priority getPriority(){
        return this.priority;
    }

    //Setters для данного класса
    public void setName(String name){
        this.name = name;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task[" +
                "taskId=" + taskId + ", " +
                "name=" + name + ", " +
                "deadline=" + deadline + ", " +
                "cost=" + cost + ", " +
                "priority=" + priority + "]";
    }
}
