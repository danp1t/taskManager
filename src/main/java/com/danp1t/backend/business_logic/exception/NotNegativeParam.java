package com.danp1t.backend.business_logic.exception;

public class NotNegativeParam extends Exception{
    @Override
    public String getMessage() {
        return "Аргумент должен быть неотрицательный";
    }
}
