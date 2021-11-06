package com.eshopper.advice;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Date;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
    private Map<String, String> errors;

    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public ErrorMessage(int statusCode, Date timestamp, String message, String description, Map<String, String> errors) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
        this.errors = errors;
    }
}