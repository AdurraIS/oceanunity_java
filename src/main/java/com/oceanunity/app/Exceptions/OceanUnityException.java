package com.oceanunity.app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class OceanUnityException extends RuntimeException{

    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Ocean Unity internal server error");
        return pb;
    }

}
