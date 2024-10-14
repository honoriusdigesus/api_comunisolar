package com.api.comunisolar.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ErrorHandler {
    //Role exception
    @ExceptionHandler(RoleException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRoleException(RoleException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(100, "ROLE_NAME_REQUIRED", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    //Nullpointer exception
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointer(NullPointerException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(101, "ROLE_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    //MyUserException exception
    @ExceptionHandler(MyUserException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUser(MyUserException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(102, "ERROR_USER_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    //NoResourceFoundException exception
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUser(NoResourceFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(103, "ERROR_USER_INFO_REQUIRED", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }
}
