package com.oceanunity.app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ObjectNotFoundException extends  OceanUnityException{

    private String message;

    public ObjectNotFoundException(String message){
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle(message + " not found!");
        return pb;
    }
}
