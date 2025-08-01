package com.bbcalife.bbcalife.exceptions.common;

import org.springframework.http.HttpStatus;

/**
 * Exception thrown to indicate access denied errors.
 * Extends ApiException and sets the appropriate message and HTTP status code.
 * Sets the appropriate message using MessageSource (the messages are in src/main/resources/messages).
 */
public class AccessDeniedException extends ApiException {
    public AccessDeniedException() {
        super("Отказан достъп!", HttpStatus.FORBIDDEN);
    }
}
