package com.bbcalife.bbcalife.exceptions.email;


import com.bbcalife.bbcalife.exceptions.common.BadRequestException;

/**
 * Exception thrown to indicate that the user's email has not been verified.
 * Extends BadRequestException and sets the appropriate message using MessageSource (the messages are in src/main/resources/messages).
 */
public class EmailNotVerified extends BadRequestException {
    public EmailNotVerified() {
        super("Не можете да влезете, имейлът, даден по време на регистрацията, не е потвърден!");
    }
}
