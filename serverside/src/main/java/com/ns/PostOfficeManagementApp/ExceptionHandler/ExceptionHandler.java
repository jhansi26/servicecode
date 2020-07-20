package com.ns.PostOfficeManagementApp.ExceptionHandler;

import com.ns.PostOfficeManagementApp.Model.Error;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<List<Error>> handleValidationError(MethodArgumentNotValidException e) {
        List<Error> exceptions=new ArrayList<Error>();
        BindingResult bindingResult = e.getBindingResult();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            String defaultMessage = error.getDefaultMessage();
            String fieldName=error.getField();
            String rejectValue=(String)error.getRejectedValue();
            Error newError = new Error(HttpStatus.BAD_REQUEST, defaultMessage, fieldName, rejectValue);
            exceptions.add(newError);
        }
        for (ObjectError error : e.getBindingResult().getGlobalErrors()) {
            Error newError = new Error(HttpStatus.BAD_REQUEST,error.getDefaultMessage(),error.getObjectName(), (error.getArguments().toString()));
            exceptions.add(newError);
        }
        return  new ResponseEntity<>(exceptions, HttpStatus.BAD_REQUEST);

    }
    @org.springframework.web.bind.annotation.ExceptionHandler( DataIntegrityViolationException.class )
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleConstraintViolation(
            DataIntegrityViolationException ex) {
        Error error=new Error(HttpStatus.BAD_REQUEST,ex.getMessage(),ex.getRootCause().toString());
        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler( ClassNotFoundException.class )
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<Object> handleClassNotFoundException(ClassNotFoundException ex) {
        ex.printStackTrace();
        Error error=new Error(HttpStatus.NOT_FOUND,ex.getClass().toString());
        System.out.println(error);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class )
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<Object> handleAll(Exception ex) {
        Error error=new Error( HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred",ex.getClass().toString());
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

