package com.danp1t.backend.business_logic.action;

import com.danp1t.backend.business_logic.entity.CommandManager;
import com.danp1t.backend.business_logic.interfaces.Command;

public class ValidateCommand {
    public static boolean isCommand(String command) {
        boolean isSlash = (command.charAt(0) == '/');
        boolean isCommand = false;
        command = command.replace("/", "");
        for (Command commandItem : CommandManager.getCommands().values()) {
            if (commandItem.getName().equals(command)) isCommand = true;
        }
        return isSlash && isCommand;
    }
}
