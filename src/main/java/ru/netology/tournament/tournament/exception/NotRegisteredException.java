package ru.netology.tournament.tournament.exception;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String msg) {
        super(msg);
    }
}
