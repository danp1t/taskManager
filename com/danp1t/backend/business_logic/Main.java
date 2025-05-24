package com.danp1t.backend.business_logic;

import com.danp1t.backend.business_logic.action.InfoAction;
import com.danp1t.backend.business_logic.action.ValidateCommand;
import com.danp1t.backend.business_logic.entity.CommandManager;
import com.danp1t.backend.business_logic.interfaces.Command;

import java.util.Scanner;

import static com.danp1t.backend.business_logic.entity.CommandManager.getCommands;

/**
 * Вспомогательный класс, который из себя представляет точку входа в программу
 */
public class Main {
    public static void main(String[] args){
        System.out.println(InfoAction.getHelloUserMessage());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите команду: ");
            String[] commandAndTokens = scanner.nextLine().split(" ");
            String commandStr = commandAndTokens[0];
            boolean isCommand = ValidateCommand.isCommand(commandStr);
            if (!isCommand) {
                System.out.println("Команда не найдена");
            }
            commandStr = commandStr.replace("/", "");
            Command command = CommandManager.getCommands().get(commandStr);
            command.run(commandAndTokens);
            System.out.println();
        }
    }
}
