package com.Ujjwal.springBootDemo.error;

import com.Ujjwal.springBootDemo.entity.ErrorMessage;
import org.assertj.core.internal.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//This class with handle all the exceptions that occur in the Controller class as we used @ControllerAdvice annotation
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    //this method will handle the exception type defined inside the annotation
    //we can create multiple methods like this to handle different kinds of exception,
    //although we can use same method for multiple exceptions aw well
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception,
                                                                   WebRequest webRequest){

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);

    }
}
