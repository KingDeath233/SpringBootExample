package com.common.exceptionClass;

import org.springframework.http.HttpStatus;

public class DBException extends RuntimeException{
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public DBException(){

    }
    public DBException(String message) {
        super(message);
    }
}
