package com.Login.exceptionhandling;

public class LoginNotFoundException extends RuntimeException {
    
    public LoginNotFoundException(String message) {
        super(message);
    }
}
