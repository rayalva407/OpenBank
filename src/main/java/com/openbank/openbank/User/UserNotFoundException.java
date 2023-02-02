package com.openbank.openbank.User;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find student with id: " + id);
    }
}
