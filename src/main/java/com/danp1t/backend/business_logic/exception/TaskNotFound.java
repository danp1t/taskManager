package com.danp1t.backend.business_logic.exception;

public class TaskNotFound extends Exception {
    public TaskNotFound() {
        super("ID задачи не был обнаружен в списке");
    }
}
