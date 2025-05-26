package com.danp1t.backend.business_logic.command;

import com.danp1t.backend.business_logic.entity.Task;
import com.danp1t.backend.business_logic.entity.TaskList;
import com.danp1t.backend.business_logic.interfaces.Command;

import java.util.ArrayList;

public class PrintTaskListCommand implements Command {
    @Override
    public String getName() {
        return "print_tasklist";
    }

    @Override
    public String getDescription() {
        return "позволяет просматривать список задач";
    }

    @Override
    public void run(String[] args) {
        ArrayList<Task> taskList = TaskList.getInstance().getAllTasks();
        if(taskList.isEmpty()){
            System.out.println("Список задач пуст!");
        }
        else {
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }
}
