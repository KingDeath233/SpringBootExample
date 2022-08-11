package com.yc.exceptionHelper;

import com.common.exceptionClass.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHelper extends ResponseEntityExceptionHandler {

    private Map<String, Object> generateResponseEntityBodyFail(String errorMessage){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", errorMessage);
        body.put("content","");
        body.put("status", false);
        return body;
    }

    @ExceptionHandler(DBException.class)
    public ResponseEntity handleException(DBException e) {
        return new ResponseEntity<>(generateResponseEntityBodyFail(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
