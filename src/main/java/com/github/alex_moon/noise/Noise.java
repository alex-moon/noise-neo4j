package com.github.alex_moon.noise;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Noise {

    protected ResponseEntity<Response> errorResponse(BindingResult bindingResult) {
        Response response = new Response(bindingResult.getFieldErrors());
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    protected ResponseEntity<Response> errorResponse(String error, HttpStatus status) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("", error);
        return new ResponseEntity<Response>(new Response(errors), status);
    }

    protected ResponseEntity<Response> errorResponse(String error) {
        return errorResponse(error, HttpStatus.OK);
    }

    protected ResponseEntity<Response> successResponse(Object entityResult) {
        return new ResponseEntity<Response>(new Response(entityResult), HttpStatus.OK);
    }

    @RequestMapping(value="/text", method=RequestMethod.POST)
    public ResponseEntity<Response> createTransaction(@RequestBody @Valid Request request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return errorResponse(bindingResult);
        }
        if (request.getText().isEmpty()) {
            return errorResponse("Whack some words in there ya fuckin");
        }
        return successResponse("lol it good");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleError(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        return errorResponse(exception.getMessage(), HttpStatus.valueOf(response.getStatus()));
    }
}
