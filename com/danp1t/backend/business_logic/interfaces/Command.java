package com.danp1t.backend.business_logic.interfaces;

/**
 * @author danp1t
 * @version 0.0.1
 * Интерфейс для команд
 */
public interface Command {
    String getName();
    String getDescription();
    void run(String[] args);
}
