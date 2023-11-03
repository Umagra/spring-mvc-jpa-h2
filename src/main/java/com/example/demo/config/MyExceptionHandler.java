package com.example.demo.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)
    public String nullPointerHandler(NullPointerException exp, Model theModel) {
        theModel.addAttribute("err", exp.getMessage());
        return "error";
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String nullPointerHandler(RuntimeException exp, Model theModel) {
        theModel.addAttribute("err", exp.getMessage());
        return "error";
    }

    @ExceptionHandler(value = Exception.class)
    public String AnyOtherHandler(Exception exp,Model theModel) {
        theModel.addAttribute("err", exp.getMessage());
        return "error";
    }

}