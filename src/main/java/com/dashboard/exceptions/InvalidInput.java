package com.dashboard.exceptions;

public class InvalidInput extends RuntimeException {
    public InvalidInput(String message) {
        super(message);
    }
}