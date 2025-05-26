package com.danp1t.backend.business_logic.utils;

import java.util.Scanner;
import java.util.function.Function;

public class CommandUtils
{
    public static <T> T inputWithRetry(String inpName, Scanner scn, Function<String, T> parseFunc){


        while(true) {
            String inp = scn.nextLine();
            if (inp.trim().isEmpty()){
                return null;
            }
            try {
                return parseFunc.apply(inp);
            } catch (Exception e) {
                System.out.println("Не удалось спарсить " + inpName);
                System.out.println("Введите ещё раз:");
            }
        }
    }
}
