package com.danp1t.backend.business_logic.utils;

import com.danp1t.backend.business_logic.exception.NotNegativeParam;

import java.util.Scanner;
import java.util.function.Function;

public class CommandUtils
{
    public static <T> T inputWithRetry(String inputName, Scanner scanner, Function<String, T> parseFunc){

        while(true) {
            String inp = scanner.nextLine();
            if (inp.trim().isEmpty()){
                return null;
            }
            try {
                return parseFunc.apply(inp);
            } catch (Exception e) {
                System.out.println("Не удалось спарсить " + inputName);
                System.out.print("Введите ещё раз: ");
            }
        }
    }

    public static Long parseTaskId(String[] args){
        Long id = null;

        try {
            id = Long.parseLong(args[1]);
            if (id < 0) throw new NotNegativeParam();
        }
        catch (NumberFormatException e) {
            System.err.println("Не удалось сконвертировать переменную в число");
        } catch (NotNegativeParam e) {
            System.err.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Для данной команды нужно ввести аргумент {id задачи}");
        }

        return id;
    }
}
