package com.danp1t.backend.business_logic.entity;

import java.util.HashMap;

import com.danp1t.backend.business_logic.command.AddTaskCommand;
import com.danp1t.backend.business_logic.command.ExitCommand;
import com.danp1t.backend.business_logic.command.HelpCommand;
import com.danp1t.backend.business_logic.command.PrintTaskListCommand;
import com.danp1t.backend.business_logic.interfaces.Command;

public class CommandManager {
    private static final HashMap<String, Command> commands = new HashMap<>();

    public static HashMap<String, Command> getCommands() {
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
        commands.put("add_task", new AddTaskCommand());
        commands.put("print_tasklist", new PrintTaskListCommand());

        return commands;
    }
}
