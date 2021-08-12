package com.project.santanderdevweek.ApiSantander.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class ExceptionResponse {

    private String message;

    public ExceptionResponse(String message){
       this.message = message;
    }
}
