package com.danp1t.backend.business_logic.command;

import com.danp1t.backend.business_logic.entity.Priority;
import com.danp1t.backend.business_logic.entity.Task;
import com.danp1t.backend.business_logic.entity.TaskList;
import com.danp1t.backend.business_logic.exception.TaskNotAdded;
import com.danp1t.backend.business_logic.exception.TaskNotFound;
import com.danp1t.backend.business_logic.interfaces.Command;
import com.danp1t.backend.business_logic.utils.CommandUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
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

        System.out.print("Введите название задания: ");
        String name = scanner.nextLine();
        if (name.isEmpty()){
            name = "Без названия";
        }
        System.out.print("Введите стоимость задачи: ");
        Double cost = CommandUtils.inputWithRetry("стоимость задачи", scanner, Double::parseDouble);

        //TODO: Можно сделать несколько шаблонов, чтобы пользователю было удобно вводить дату
        System.out.print("Введите дедлайн задачи в формате dd-MM-yyyy HH:mm: ");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime deadline = CommandUtils.inputWithRetry("дату", scanner, (x)->LocalDateTime.parse(x, formatter));

        System.out.println("Доступные приоритеты: " + Arrays.toString(Priority.values()));
        System.out.print("Выберете приоритет задачи: ");
        Priority priority = CommandUtils.inputWithRetry("приоритет задачи", scanner, Priority::valueOf);

        Task task = new Task(name, cost, deadline, priority);

        try {
            TaskList.getInstance().AddTask(task);
            System.out.println("Задача успешно добавлена!");
        }
        catch (TaskNotAdded e) {
            System.err.println(e.getMessage());
        }
    }
}
