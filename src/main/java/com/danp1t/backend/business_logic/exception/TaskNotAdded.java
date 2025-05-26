package com.danp1t.backend.business_logic.exception;

public class TaskNotAdded extends Exception {
    public TaskNotAdded() {
        super("Не удалось добавить задачу в список, так как превышен лимит количества задач для одного пользователя");
    }
}
