package com.danp1t.backend.business_logic;

import com.danp1t.backend.business_logic.action.InfoAction;
import com.danp1t.backend.business_logic.action.ValidateCommand;
import com.danp1t.backend.business_logic.entity.CommandManager;
import com.danp1t.backend.business_logic.interfaces.Command;

import java.util.Scanner;

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
            if(!ValidateCommand.isCommandLikeString(commandStr)){
                System.out.println("Команда должна начинаться со слэша!");
                continue;
            }
            boolean isCommand = ValidateCommand.isCommand(commandStr);
            if (!isCommand) {
                System.out.println("Команда не найдена");
                continue;
            }
            commandStr = commandStr.replace("/", "");
            Command command = CommandManager.getCommands().get(commandStr);
            command.run(commandAndTokens);
            System.out.println();
        }
    }
}
