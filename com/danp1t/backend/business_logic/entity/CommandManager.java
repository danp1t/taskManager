package com.danp1t.backend.business_logic.entity;

import java.util.HashMap;
import java.util.Map;

import com.danp1t.backend.business_logic.command.HelpCommand;
import com.danp1t.backend.business_logic.interfaces.Command;

public class CommandManager {
    private static final HashMap<String, Command> commands = new HashMap<>();

    public static HashMap<String, Command> getCommands() {
        commands.put("help", new HelpCommand());


        return commands;
    }
}
