package com.petar.asistent.exception;

import java.util.Arrays;
import java.util.List;

public class AsistentException extends Exception{

    private final List<String> errorMessages;

    public AsistentException(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public AsistentException(List<String> errorMessages, String message, Throwable cause) {
        super(message, cause);
        this.errorMessages = errorMessages;
    }

    public AsistentException(String message) {
        super(message);
        this.errorMessages = Arrays.asList(message);
    }

    public AsistentException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessages = Arrays.asList(message);
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
    
}
