package com.bturkmen.springaop.aspects;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(final String message) {
        super(message);
    }
}
