package com.github.alex_moon.noise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;

public class Response {
    Map<String, String> errors;
    Object result;
    String status;

    public Response(List<FieldError> errors) {
        this.errors = new HashMap<String, String>();
        for (FieldError error : errors) {
            this.errors.put(error.getField(), error.getDefaultMessage());
        }
        status = "error";
    }

    public Response(Map<String, String> errors) {
        this.errors = errors;
        status = "error";
    }

    public Response(Object result) {
        this.result = result;
        status = "success";
    }
}
