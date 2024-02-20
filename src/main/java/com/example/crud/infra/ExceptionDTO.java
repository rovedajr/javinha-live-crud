package com.example.crud.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionDTO {
    @JsonProperty("message")
    String message;
    public ExceptionDTO(String message){
        this.message = message;
    }
}
