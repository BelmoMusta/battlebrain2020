package musta.belmo.cody.rest;

import musta.belmo.cody.service.api.exceptions.ApplicationException;
import musta.belmo.cody.service.api.exceptions.ErrorWrapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ApplicationException.class})
    public ResponseEntity<ErrorWrapper> handle(ApplicationException e) {
        return ResponseEntity.status(e.getErrorWrapper().getCode())
                .body(e.getErrorWrapper());

    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity handleOthers(Exception e) {
        logger.error("Error : ", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());

    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity handleOthers(DataIntegrityViolationException e, WebRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());

    }
    
    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity handleOthers(IOException e, WebRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());

    }
}
