package com.bbcalife.bbcalife.exceptions.user;


import com.bbcalife.bbcalife.exceptions.common.NoSuchElementException;

/**
 * Exception indicating that the user is not found.
 * Sets the appropriate message using MessageSource (the messages are in src/main/resources/messages).
 */
public class UserNotFoundException extends NoSuchElementException {
    public UserNotFoundException() {
        super("Потребителят не е намерен!");
    }
}