package com.rakovets.course.java.core.practice.concurrency.producer_queue_consumer.exception;

import java.util.InputMismatchException;

public class UserInputException extends InputMismatchException {
    public UserInputException(String message) {
        super(message);
    }
}
