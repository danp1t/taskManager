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
import java.util.Arrays;
import java.util.Scanner;

import static com.danp1t.backend.business_logic.utils.CommandUtils.parseTaskId;

public class EditTaskCommand implements Command {
    @Override
    public String getName() {
        return "edit_task";
    }

    @Override
    public String getDescription() {
        return "редактирует конкретную задачу";
    }

    @Override
    public void run(String[] args) {
        Long id = parseTaskId(args);
        if (id == null) return;

        Task taskOld = TaskList.getInstance().getTaskById(id);

        System.out.println("Если хотите оставить старое значение, то нажмите ENTER");
        Scanner scanner = new Scanner(System.in);

        System.out.print("(Текущее значение: " + taskOld.name() + ") Введите название задания: ");
        String name = scanner.nextLine();
        if (name.isEmpty()){
            name = taskOld.name();
        }
        System.out.print("(Текущее значение: " + taskOld.cost() + ") Введите стоимость задачи: ");
        Double cost = CommandUtils.inputWithRetry("стоимость задачи", scanner, Double::parseDouble);
        if (cost == null) {
            cost = taskOld.cost();
        }

        //TODO: Можно сделать несколько шаблонов, чтобы пользователю было удобно вводить дату
        System.out.print("(Текущее значение: " + taskOld.deadline() + ") Введите дедлайн задачи в формате dd-MM-yyyy HH:mm: ");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime deadline = CommandUtils.inputWithRetry("дату", scanner, (x)->LocalDateTime.parse(x, formatter));
        if (deadline == null) {
            deadline = taskOld.deadline();
        }

        System.out.println("Доступные приоритеты: " + Arrays.toString(Priority.values()));
        System.out.print("(Текущее значение: " + taskOld.priority() + ") Выберете приоритет задачи: ");
        Priority priority = CommandUtils.inputWithRetry("приоритет задачи", scanner, Priority::valueOf);
        if (priority == null) {
            priority = taskOld.priority();
        }

        Task task = new Task(id, name, cost, deadline, priority);

        try {
            TaskList.getInstance().deleteTaskById(id);
            TaskList.getInstance().AddTask(task);
            System.out.println("Задача успешно изменена!");
        }
        catch (TaskNotAdded | TaskNotFound e) {
            System.err.println(e.getMessage());
        }

    }
}
