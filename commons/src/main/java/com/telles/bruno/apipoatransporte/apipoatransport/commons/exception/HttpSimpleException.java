package com.telles.bruno.apipoatransporte.apipoatransport.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpSimpleException extends RuntimeException{
    private final String message;
    private final int status;
    private final HttpStatus httpStatus;

    public HttpSimpleException(String message, int status, HttpStatus httpStatus) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
    }
}
