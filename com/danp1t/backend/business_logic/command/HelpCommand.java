package com.danp1t.backend.business_logic.command;

import com.danp1t.backend.business_logic.entity.CommandManager;
import com.danp1t.backend.business_logic.interfaces.Command;

import java.util.HashMap;

/**
 * @author danp1t
 * Класс выводит информацию о доступных командах
 */
public class HelpCommand implements Command {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "выводит информацию о доступных командах";
    }

    @Override
    public void run(String[] args) {
        System.out.println("Доступные команды: ");
        HashMap<String, Command> commands = CommandManager.getCommands();
        for (Command command : commands.values()){
            System.out.println("/" + command.getName() + " - " + command.getDescription());
        }
    }
}
