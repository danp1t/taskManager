package com.danp1t.backend.business_logic.command;

import com.danp1t.backend.business_logic.entity.Task;
import com.danp1t.backend.business_logic.entity.TaskList;
import com.danp1t.backend.business_logic.exception.NotNegativeParam;
import com.danp1t.backend.business_logic.exception.TaskNotFound;
import com.danp1t.backend.business_logic.interfaces.Command;

import java.util.ArrayList;
import java.util.Objects;

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
        Long id = null;

        try {
            id = Long.parseLong(args[1]);
            if (id < 0) throw new NotNegativeParam();
        }
        catch (NumberFormatException e) {
            System.err.println("Не удалось сконвертировать переменную в число");
            return;
        } catch (NotNegativeParam e) {
            System.err.println(e.getMessage());
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Для данной команды нужно ввести аргумент {id задачи}");
            return;
        }

        try{
            TaskList.getInstance().deleteTaskById(id);
            System.out.println("Задача успешно удалена!");
        }
        catch (TaskNotFound e) {
            System.err.println(e.getMessage());
        }
    }
}
