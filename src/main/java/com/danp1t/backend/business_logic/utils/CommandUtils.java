package com.danp1t.backend.business_logic.utils;

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
}
