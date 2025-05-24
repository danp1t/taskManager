package com.danp1t.backend.business_logic.command;

import com.danp1t.backend.business_logic.entity.Priority;
import com.danp1t.backend.business_logic.entity.Task;
import com.danp1t.backend.business_logic.entity.TaskList;
import com.danp1t.backend.business_logic.interfaces.Command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddTaskCommand implements Command {
    @Override
    public String getName() {
        return "add_task";
    }

    @Override
    public String getDescription() {
        return "добавляет задачу в список задач";
    }

    @Override
    public void run(String[] args) {
        System.out.println("Если хотите пропустить ввод значения, то нажмите ENTER");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = TaskList.getTaskList();

        System.out.print("Введите название задания: ");
        String name = scanner.nextLine();

        System.out.print("Введите стоимость задачи: ");
        String stringCost = scanner.nextLine();
        Double cost = 0.0;
        try {
            cost = Double.parseDouble(stringCost);
        }
        catch (NumberFormatException e) {
            System.out.println("Не удалось спарсить стоимость задачи");
            Task task = new Task(name);
            taskList.add(task);
            return;
        }

        //TODO: Можно сделать несколько шаблонов, чтобы пользователю было удобно вводить дату
        System.out.print("Введите дедлайн задачи в формате dd-MM-yyyy HH:mm: ");
        String stringDeadline = scanner.nextLine();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime deadline = null;
        try {
             deadline = LocalDateTime.parse(stringDeadline, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Не удалось спарсить дату");
            Task task = new Task(name, cost);
            taskList.add(task);
            return;
        }

        System.out.print("Выберете приоритет задачи: ");
        String stringPriority = scanner.nextLine();
        Priority priority = Priority.NOT_STATED;
        try {
            priority = Priority.valueOf(stringPriority);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Не удалось спарсить приоритет задачи");
            Task task = new Task(name, cost, deadline);
            taskList.add(task);
            return;
        }

        Task task = new Task(name, cost, deadline, priority);
        taskList.add(task);
    }
}
