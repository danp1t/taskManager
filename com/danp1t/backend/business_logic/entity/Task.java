package com.danp1t.backend.business_logic.entity;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author danp1t
 * @since 0.0.1
 * Данный клас описывает сущность "Задача"
 */
public record Task(Long taskId, String name, Double cost, LocalDateTime deadline, Priority priority) {
    /**
     * @since 0.0.1
     * id - уникальный индетификатор задачи
     * name - название задачи
     * deadline - дедлайн задачи
     * cost - цена/вес задачи
     * priority - приоритет задачи
     */
    private static final AtomicLong idCounter = new AtomicLong(0);


    /**
     * Различные конструкторы для создания объекта "Задача"
     */
    public Task(String name, Double cost, LocalDateTime deadline, Priority priority){
        this(idCounter.getAndIncrement(),
                name==null ? "Без названия" : name,
                cost==null ? 0.0 : cost,
                deadline,
                priority==null ? Priority.NOT_STATED : priority
        );
    }
}
