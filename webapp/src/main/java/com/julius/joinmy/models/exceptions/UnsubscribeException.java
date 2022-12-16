package com.julius.joinmy.models.exceptions;

public class UnsubscribeException extends RuntimeException{
    public UnsubscribeException() {
        super("Usuario no esta subscrito");
    }
}
