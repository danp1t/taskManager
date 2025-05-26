package com.danp1t.backend.business_logic.command;

import com.danp1t.backend.business_logic.entity.Task;
import com.danp1t.backend.business_logic.entity.TaskList;
import com.danp1t.backend.business_logic.exception.NotNegativeParam;
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
        ArrayList<Task> taskList = TaskList.getTaskList();
        Integer startSize = taskList.size();
        Long id = null;

        try {
            id = Long.parseLong(args[1]);
            if (id < 0) throw new NotNegativeParam();
        }
        catch (NumberFormatException e) {
            System.err.print("Не удалось сконвертировать переменную в число");
        } catch (NotNegativeParam e) {
            System.err.print(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Для данной команды нужно ввести аргумент {id задачи}");
        }

        for (int i = 0; i < taskList.size(); i++) {
            if (Objects.equals(taskList.get(i).getTaskId(), id)) {
                taskList.remove(i);
                return;
            }
        }
        if (startSize == taskList.size()){
            System.err.print("ID задачи не был обнаружен в списке");
        }
    }
}
