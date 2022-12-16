package com.julius.joinmy.models.exceptions;

public class SubscribeException extends RuntimeException{
    public SubscribeException() {
        super("Usuario ya subscrito");
    }
}
