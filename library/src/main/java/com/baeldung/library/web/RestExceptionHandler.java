package com.baeldung.library.web;

import com.baeldung.library.web.exception.BookIdMismatchException;
import com.baeldung.library.web.exception.BookNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BookNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception e, WebRequest request) {
        return handleExceptionInternal(e, "Book not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({BookIdMismatchException.class,
            ConstraintViolationException.class,
            DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleBadRequest(Exception e, WebRequest request) {
        return handleExceptionInternal(e, e.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
