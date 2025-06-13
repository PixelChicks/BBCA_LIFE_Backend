package com.bbcalife.bbcalife.exceptions.token;


import com.bbcalife.bbcalife.exceptions.common.UnauthorizedException;

public class ExpiredTokenException extends UnauthorizedException {
    public ExpiredTokenException() {
        super("Токенът е изтекъл!");
    }
}
