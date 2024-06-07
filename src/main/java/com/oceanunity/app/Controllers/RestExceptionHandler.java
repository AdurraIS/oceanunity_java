package com.oceanunity.app.Controllers;

import com.oceanunity.app.Exceptions.OceanUnityException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(OceanUnityException.class)
    public ProblemDetail handleOceanUnityException(OceanUnityException exception){
        return exception.toProblemDetail();
    }

}
