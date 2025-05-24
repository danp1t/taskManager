package com.danp1t.backend.business_logic.command;

import com.danp1t.backend.business_logic.interfaces.Command;

public class ExitCommand implements Command {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "выходит из программы";
    }

    @Override
    public void run(String[] args) {
        System.exit(0);
    }
}
