package com.danp1t.backend.business_logic.command;

import com.danp1t.backend.business_logic.entity.TaskList;
import com.danp1t.backend.business_logic.exception.TaskNotFound;
import com.danp1t.backend.business_logic.interfaces.Command;

import static com.danp1t.backend.business_logic.utils.CommandUtils.parseTaskId;

public class DeleteTaskCommand implements Command {
    @Override
    public String getName() {
        return "delete_task";
    }

    @Override
    public String getDescription() {
        return "удаляет задачу из списка задач по ID";
    }

    @Override
    public void run(String[] args) {
        Long id = parseTaskId(args);
        if (id == null) return;

        try {
            TaskList.getInstance().deleteTaskById(id);
            System.out.println("Задача успешно удалена!");
        }
        catch (TaskNotFound e) {
            System.err.println(e.getMessage());
        }
    }
}
