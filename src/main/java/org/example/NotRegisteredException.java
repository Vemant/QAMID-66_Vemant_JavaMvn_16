package org.example;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Player " + playerName + " is not found");
    }
}
